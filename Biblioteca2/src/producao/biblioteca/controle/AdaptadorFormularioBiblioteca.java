package producao.biblioteca.controle;

import producao.biblioteca.visao.CamposFormularioBiblioteca;
import producao.biblioteca.visao.VisaoBiblioteca;
import producao.dados.ExcecaoParametroInvalido;
import producao.dados.autor.modelo.Autor;
import producao.dados.nome.modelo.Nome;
import producao.dados.numeroChamada.modelo.NumeroChamada;
import producao.formulario.AdaptadorFormularioAbstrato;
import producao.livro.Livro;
import producao.livro.arquivavel.dados.DadosLivroArquivavel;
import producao.livro.dados.DadosLivro;
import producao.livro.editora.Editora;

public class AdaptadorFormularioBiblioteca extends AdaptadorFormularioAbstrato {
	private CamposFormularioBiblioteca campos;
	private Editora editora;

	public AdaptadorFormularioBiblioteca(VisaoBiblioteca visao) {
		super(visao.obterCamposFormulario());
		this.campos = visao.obterCamposFormulario();
		editora = new Editora();
	}

	public Livro adaptarLivro() {
		return criarLivro();
	}

	public DadosLivroArquivavel adaptarDadosDeArquivo() {
		return new DadosLivroArquivavel(criarNumeroChamada());
	}

	private Livro criarLivro() {
		DadosLivro dados = new DadosLivro(criarTitulo(), criarAutor(),
				criarNomeEditora(), criarAnoPublicacao());

		return editora.criarLivro(dados);
	}

	private Autor criarAutor() {
		try {
			return new Autor(campos.obterAutor());
		} catch (ExcecaoParametroInvalido e) {
			notificarAlteracao(e.getLocalizedMessage(), this);
		}

		return null;
	}

	private Nome criarNomeEditora() {
		try {
			return new Nome(campos.obterNomeEditora());
		} catch (ExcecaoParametroInvalido e) {
			notificarAlteracao("Campo Nome da Editora vazio", this);
		}

		return null;
	}

	private NumeroChamada criarNumeroChamada() {
		try {
			return new NumeroChamada(campos.obterNumeroChamada());
		} catch (ExcecaoParametroInvalido e) {
			notificarAlteracao(e.getLocalizedMessage(), this);
		}

		return null;
	}

	public boolean dadosDeArquivoPreenchidos() {
		return !campos.obterNumeroChamada().isEmpty();
	}
}

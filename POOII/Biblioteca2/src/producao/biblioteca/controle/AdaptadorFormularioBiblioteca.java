package producao.biblioteca.controle;

import producao.biblioteca.visao.CamposFormularioBiblioteca;
import producao.biblioteca.visao.VisaoBiblioteca;
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
		verificarCampos();

		DadosLivro dados = new DadosLivro(criarTitulo(), criarAutor(),
				criarNomeEditora(), criarAnoPublicacao());

		return editora.criarLivro(dados);
	}

	private Autor criarAutor() {
		return new Autor(campos.obterAutor());

	}

	private Nome criarNomeEditora() {
		return new Nome(campos.obterNomeEditora());

	}

	private NumeroChamada criarNumeroChamada() {
		return new NumeroChamada(campos.obterNumeroChamada());

	}

	public boolean dadosDeArquivoPreenchidos() {
		return !campos.obterNumeroChamada().isEmpty();
	}

	public void verificarCampos() {
		super.verificarCampos();

		if (!Autor.validar(campos.obterAutor()))
			notificarAlteracao("Nome do Autor inválido", this);

		if (!Nome.validar(campos.obterNomeEditora()))
			notificarAlteracao("Nome da editora inválido", this);

	}
}

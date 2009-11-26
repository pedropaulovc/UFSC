package producao.formulario;

import java.util.Observable;

import producao.biblioteca.visao.VisaoBiblioteca;
import producao.dados.ExcecaoParametroInvalido;
import producao.dados.anoPublicacao.modelo.AnoPublicacao;
import producao.dados.autor.modelo.Autor;
import producao.dados.nome.modelo.Nome;
import producao.dados.numeroChamada.modelo.NumeroChamada;
import producao.formulario.campos.CamposFormularioBiblioteca;
import producao.livro.TipoLivro;
import producao.livro.arquivavel.dados.DadosLivroArquivavel;
import producao.livro.arquivavel.dados.TipoDadosLivroArquivavel;
import producao.livro.dados.DadosLivro;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.editora.Editora;
import producao.log.modelo.Mensagem;

public class AdaptadorFormularioBiblioteca extends Observable {
	private CamposFormularioBiblioteca campos;
	private Editora editora;

	public AdaptadorFormularioBiblioteca(VisaoBiblioteca visao) {
		this.campos = visao.obterCamposFormulario();
		editora = new Editora();
	}

	public TipoLivro adaptarLivro() {
		return criarLivro();
	}

	public TipoDadosLivroArquivavel adaptarDadosDeArquivo() {
		return new DadosLivroArquivavel(criarNumeroChamada());
	}

	private TipoLivro criarLivro() {
		TipoDadosLivro dados = new DadosLivro(criarTitulo(), criarAutor(),
				criarNomeEditora(), criarAnoPublicacao());

		return editora.criarLivro(dados);
	}

	private Nome criarTitulo() {
		try {
			return new Nome(campos.obterTitulo());
		} catch (ExcecaoParametroInvalido e) {
			notificarAlteracao(e.getLocalizedMessage(), this);
		}

		return null;
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
			notificarAlteracao(e.getLocalizedMessage(), this);
		}

		return null;
	}

	private AnoPublicacao criarAnoPublicacao() {

		try {
			return new AnoPublicacao(campos.obterAnoPublicacao());
		} catch (ExcecaoParametroInvalido e) {
			notificarAlteracao(e.getLocalizedMessage(), this);
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

	private void notificarAlteracao(String mensagem, Object o) {
		setChanged();
		notifyObservers(new Mensagem(mensagem, o));
	}
}

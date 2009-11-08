package producao.formulario;

import producao.biblioteca.visao.TipoVisaoBiblioteca;
import producao.dados.anoPublicacao.modelo.AnoPublicacao;
import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.autor.modelo.Autor;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nomeEditora.modelo.NomeEditora;
import producao.dados.nomeEditora.modelo.TipoNomeEditora;
import producao.dados.numeroChamada.modelo.NumeroChamada;
import producao.dados.numeroChamada.modelo.TipoNumeroChamada;
import producao.dados.titulo.modelo.TipoTitulo;
import producao.dados.titulo.modelo.Titulo;
import producao.formulario.campos.TipoCamposFormulario;
import producao.livro.Livro;
import producao.livro.TipoLivro;
import producao.livro.arquivavel.dados.DadosLivroArquivavel;
import producao.livro.arquivavel.dados.TipoDadosLivroArquivavel;
import producao.livro.dados.DadosLivro;
import producao.livro.dados.TipoDadosLivro;

public class AdaptadorFormulario implements TipoAdaptadorFormulario {
	private TipoCamposFormulario campos;

	public AdaptadorFormulario(TipoVisaoBiblioteca visao) {
		this.campos = visao.obterCamposFormulario();
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

		return new Livro(dados);
	}

	private TipoTitulo criarTitulo() {
		return new Titulo(campos.obterTitulo());
	}

	private TipoAutor criarAutor() {
		return new Autor(campos.obterAutor());
	}

	private TipoNomeEditora criarNomeEditora() {
		return new NomeEditora(campos.obterNomeEditora());
	}

	private TipoAnoPublicacao criarAnoPublicacao() {
		return new AnoPublicacao(campos.obterAnoPublicacao());
	}

	private TipoNumeroChamada criarNumeroChamada() {
		return new NumeroChamada(campos.obterNumeroChamada());
	}

}

package producao.livro.dados;

import producao.livro.autor.TipoAutor;
import producao.livro.exemplar.anoPublicacao.TipoAnoPublicacao;
import producao.livro.exemplar.nomeEditora.TipoNomeEditora;
import producao.livro.titulo.TipoTitulo;

public class DadosLivro implements TipoDadosLivro {
	private TipoTitulo titulo;
	private TipoAutor autor;
	private TipoNomeEditora editora;
	private TipoAnoPublicacao anoPublicacao;

	public DadosLivro(TipoTitulo titulo, TipoAutor autor,
			TipoNomeEditora editora, TipoAnoPublicacao anoPublicacao) {

		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.anoPublicacao = anoPublicacao;
	}

	public TipoTitulo obterTitulo() {
		return titulo;
	}

	public TipoAutor obterAutor() {
		return autor;
	}

	public TipoNomeEditora obterEditora() {
		return editora;
	}

	public TipoAnoPublicacao obterAnoPublicacao() {
		return anoPublicacao;
	}

}

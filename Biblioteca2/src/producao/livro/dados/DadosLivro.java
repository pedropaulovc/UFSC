package producao.livro.dados;

import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nomeEditora.modelo.TipoNomeEditora;
import producao.dados.titulo.modelo.TipoTitulo;

public class DadosLivro implements TipoDadosLivro {
	private TipoTitulo titulo;
	private TipoAutor autor;
	private TipoNomeEditora editora;
	private TipoAnoPublicacao anoPublicacao;

	public DadosLivro(TipoTitulo titulo, TipoAutor autor,
			TipoNomeEditora editora, TipoAnoPublicacao anoPublicacao) {
		assert titulo != null;
		assert autor != null;
		assert editora != null;
		assert anoPublicacao != null;

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

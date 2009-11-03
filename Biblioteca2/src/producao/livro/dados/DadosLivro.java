package producao.livro.dados;

import producao.dados.anoPublicacao.TipoAnoPublicacao;
import producao.dados.autor.TipoAutor;
import producao.dados.nomeEditora.TipoNomeEditora;
import producao.dados.titulo.TipoTitulo;

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

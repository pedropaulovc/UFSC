package producao.livro.dados;

import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nome.modelo.TipoNome;

public class DadosLivro implements TipoDadosLivro {
	private TipoNome titulo;
	private TipoAutor autor;
	private TipoNome editora;
	private TipoAnoPublicacao anoPublicacao;

	public DadosLivro(TipoNome titulo, TipoAutor autor,
			TipoNome editora, TipoAnoPublicacao anoPublicacao) {
		assert titulo != null;
		assert autor != null;
		assert editora != null;
		assert anoPublicacao != null;

		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.anoPublicacao = anoPublicacao;
	}

	public TipoNome obterTitulo() {
		return titulo;
	}

	public TipoAutor obterAutor() {
		return autor;
	}

	public TipoNome obterEditora() {
		return editora;
	}

	public TipoAnoPublicacao obterAnoPublicacao() {
		return anoPublicacao;
	}

}

package producao.livro.dados;

import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.dados.DadosDocumento;

public class DadosLivro extends DadosDocumento implements TipoDadosLivro {
	private TipoAutor autor;
	private TipoNome editora;

	public DadosLivro(TipoNome titulo, TipoAutor autor, TipoNome editora,
			TipoAnoPublicacao anoPublicacao) {
		super(titulo, anoPublicacao);
		assert autor != null;
		assert editora != null;

		this.autor = autor;
		this.editora = editora;
	}

	public TipoAutor obterAutor() {
		return autor;
	}

	public TipoNome obterEditora() {
		return editora;
	}

}

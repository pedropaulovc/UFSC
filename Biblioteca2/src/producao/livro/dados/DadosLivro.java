package producao.livro.dados;

import producao.dados.ExcecaoParametroInvalido;
import producao.dados.anoPublicacao.modelo.AnoPublicacao;
import producao.dados.autor.modelo.Autor;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nome.modelo.Nome;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.dados.DadosDocumento;

public class DadosLivro extends DadosDocumento implements TipoDadosLivro {
	private TipoAutor autor;
	private TipoNome editora;

	public DadosLivro(Nome titulo, Autor autor, Nome editora,
			AnoPublicacao anoPublicacao) {
		super(titulo, anoPublicacao);
		assert autor != null;
		assert editora != null;

		if(autor == null || editora == null)
			throw new ExcecaoParametroInvalido("Parâmetros inválidos");
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

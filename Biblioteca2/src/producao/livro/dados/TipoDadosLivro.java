package producao.livro.dados;

import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nome.modelo.TipoNome;

public interface TipoDadosLivro {
	public TipoNome obterTitulo();

	public TipoAutor obterAutor();

	public TipoNome obterEditora();

	public TipoAnoPublicacao obterAnoPublicacao();
}

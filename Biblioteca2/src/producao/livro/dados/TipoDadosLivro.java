package producao.livro.dados;

import producao.livro.autor.TipoAutor;
import producao.livro.exemplar.anoPublicacao.TipoAnoPublicacao;
import producao.livro.exemplar.nomeEditora.TipoNomeEditora;
import producao.livro.titulo.TipoTitulo;

public interface TipoDadosLivro {
	public TipoTitulo obterTitulo();

	public TipoAutor obterAutor();

	public TipoNomeEditora obterEditora();

	public TipoAnoPublicacao obterAnoPublicacao();
}

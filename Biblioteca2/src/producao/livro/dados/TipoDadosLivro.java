package producao.livro.dados;

import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.autor.TipoAutor;
import producao.dados.nomeEditora.TipoNomeEditora;
import producao.dados.titulo.TipoTitulo;

public interface TipoDadosLivro {
	public TipoTitulo obterTitulo();

	public TipoAutor obterAutor();

	public TipoNomeEditora obterEditora();

	public TipoAnoPublicacao obterAnoPublicacao();
}

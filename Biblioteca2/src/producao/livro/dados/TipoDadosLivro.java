package producao.livro.dados;

import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nomeEditora.TipoNomeEditora;
import producao.dados.titulo.modelo.TipoTitulo;

public interface TipoDadosLivro {
	public TipoTitulo obterTitulo();

	public TipoAutor obterAutor();

	public TipoNomeEditora obterEditora();

	public TipoAnoPublicacao obterAnoPublicacao();
}

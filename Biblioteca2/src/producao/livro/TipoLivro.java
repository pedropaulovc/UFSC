package producao.livro;

import producao.documento.TipoAnoPublicacao;
import producao.documento.TipoAutor;
import producao.documento.TipoNomeEditora;
import producao.documento.TipoTitulo;

public interface TipoLivro {
	public TipoAnoPublicacao obterAnoPublicacao();
	public TipoAutor obterAutor();
	public TipoNomeEditora obterEditora();
	public TipoTitulo obterTitulo();
}

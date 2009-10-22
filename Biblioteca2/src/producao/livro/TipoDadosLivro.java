package producao.livro;

import producao.documento.TipoAnoPublicacao;
import producao.documento.TipoAutor;
import producao.documento.TipoNomeEditora;
import producao.documento.TipoTitulo;

public interface TipoDadosLivro {
	public TipoTitulo obterTitulo();
	public TipoAutor obterAutor();
	public TipoNomeEditora obterEditora();
	public TipoAnoPublicacao obterAnoPublicacao();
}

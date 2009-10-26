package producao.livro.dados;

import producao.livro.autor.TipoAutor;
import producao.livro.id.TipoIdLivro;
import producao.livro.titulo.TipoTitulo;

public interface TipoDadosLivro {
	public TipoTitulo obterTitulo();

	public TipoAutor obterAutor();
	
	public TipoIdLivro obterIdentificacao();
}

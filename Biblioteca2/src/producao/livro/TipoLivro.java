package producao.livro;

import producao.livro.autor.TipoAutor;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.id.TipoIdLivro;
import producao.livro.titulo.TipoTitulo;

public interface TipoLivro {
	public TipoAutor obterAutor();

	public TipoTitulo obterTitulo();
	
	public TipoIdLivro obterId();
	
	public TipoDadosLivro obterDados();
}

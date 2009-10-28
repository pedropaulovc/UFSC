package producao.livro;

import producao.livro.autor.TipoAutor;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.id.TipoIdLivro;
import producao.livro.titulo.TipoTitulo;

public class Livro implements TipoLivro {

	private TipoDadosLivro dados;

	public Livro(TipoDadosLivro dados){
		this.dados = dados;
	}
	
	public TipoAutor obterAutor() {
		return dados.obterAutor();
	}

	public TipoTitulo obterTitulo() {
		return dados.obterTitulo();
	}
	
	public TipoIdLivro obterId(){
		return dados.obterId();
	}
	
	public TipoDadosLivro obterDados(){
		return dados;
	}
}

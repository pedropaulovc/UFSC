package producao.livro;


public class Livro implements TipoLivro {
	private TipoDadosLivro dados;

	public Livro(TipoDadosLivro dados){
		this.dados = dados;
	}

	public TipoAnoPublicacao obterAnoPublicacao() {
		return dados.obterAnoPublicacao();
	}

	public TipoAutor obterAutor() {
		return dados.obterAutor();
	}

	public TipoNomeEditora obterEditora() {
		return dados.obterEditora();
	}

	public TipoTitulo obterTitulo() {
		return dados.obterTitulo();
	}
	
	
}

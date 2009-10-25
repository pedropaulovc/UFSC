package producao.livro;

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
	
	public TipoIdentificacaoLivro obterIdentificacao(){
		return dados.obterIdentificacao();
	}
	
	public TipoDadosLivro obterDados(){
		return dados;
	}
}

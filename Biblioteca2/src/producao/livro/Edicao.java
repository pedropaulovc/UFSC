package producao.livro;

public class Edicao implements TipoEdicao {
	private String edicao;

	public Edicao(String edicao){
		this.edicao = edicao;
	}
	
	public String toString(){
		return edicao;
	}
	
}

package producao.documento;

public class EdicaoConcreta implements Edicao {
	private String edicao;

	public EdicaoConcreta(String edicao){
		this.edicao = edicao;
	}
	
	public String toString(){
		return edicao;
	}
	
}

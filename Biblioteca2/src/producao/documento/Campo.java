package producao.documento;

public class Campo implements TipoCampo {
	private String campo;

	public Campo(String campo){
		this.campo = campo;
	}
	
	public String toString(){
		return campo;
	}
}

package producao.documento;

public class CampoConcreto implements Campo {
	private String campo;

	public CampoConcreto(String campo){
		this.campo = campo;
	}
	
	public String toString(){
		return campo;
	}
}

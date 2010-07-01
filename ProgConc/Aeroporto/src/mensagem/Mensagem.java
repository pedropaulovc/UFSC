package mensagem;

public class Mensagem {

	private CodigosMensagem codigo;
	private int id;
	private int pista;

	public void definirCodigo(CodigosMensagem codigo) {
		this.codigo = codigo;
	}

	public CodigosMensagem obterCodigo() {
		return codigo;
	}

	public int obterId() {
		return id;
	}

	public void definirId(int id){
		this.id = id;
	}

	public void definirPista(int pista) {
		this.pista = pista;
	}
	
	public int obterPista(){
		return pista; 
	}
}

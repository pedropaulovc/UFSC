package producao.documento;


public class AnoPublicacao implements TipoAnoPublicacao {

	private int anoPublicacao;

	public AnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	public AnoPublicacao(String anoPublicacao) {
		Integer.parseInt(anoPublicacao);
	}

	public String toString(){
		return Integer.toString(anoPublicacao);
	}

}

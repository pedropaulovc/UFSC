package producao.documento;


public class AnoPublicacaoConcreto implements AnoPublicacao {

	private int anoPublicacao;

	public AnoPublicacaoConcreto(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	public String toString(){
		return Integer.toString(anoPublicacao);
	}

}

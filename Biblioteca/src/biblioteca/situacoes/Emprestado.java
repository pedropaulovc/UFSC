package biblioteca.situacoes;
import java.util.Date;


public class Emprestado implements Situacao {
	private Date dataDevolucao;
	
	public Emprestado(){
		dataDevolucao = new Date();
	}
	
	public Situacao clone(){
		try {
			return (Situacao) super.clone();
		} catch (CloneNotSupportedException excecao) {
			return this;
		}
	}
}

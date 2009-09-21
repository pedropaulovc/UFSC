package biblioteca.situacoes;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Emprestado implements Situacao {
	private GregorianCalendar dataDevolucao;
	
	public Emprestado(){
		calcularDataDevolucao();
	}

	private void calcularDataDevolucao() {
		dataDevolucao = new GregorianCalendar();
		dataDevolucao.add(Calendar.DAY_OF_YEAR, 15);
	}
	
	public Situacao clone(){
		try {
			return (Situacao) super.clone();
		} catch (CloneNotSupportedException excecao) {
			return this;
		}
	}
}

package producao.dados.anoPublicacao.modelo;

import java.util.Calendar;

public class AnoPublicacao implements TipoAnoPublicacao {

	private int anoPublicacao;

	public AnoPublicacao(int anoPublicacao) {
		assert anoPublicacao > 0;
		assert anoPublicacao <= Calendar.getInstance().get(Calendar.YEAR);
		this.anoPublicacao = anoPublicacao;
	}

	public AnoPublicacao(String anoPublicacao) {
		this(Integer.parseInt(anoPublicacao));
	}

	public String toString() {
		return Integer.toString(anoPublicacao);
	}

}

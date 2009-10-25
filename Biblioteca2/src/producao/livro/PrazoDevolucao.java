package producao.livro;

import java.util.Calendar;

public class PrazoDevolucao implements TipoPrazoDevolucao {

	private int dataDevolucao;

	public PrazoDevolucao(int prazo) {
		if (prazo < 0)
			this.dataDevolucao = diaAtual();
		this.dataDevolucao = diaAtual() + prazo;
	}

	public boolean estaNoPrazo() {
		if (diaAtual() <= dataDevolucao)
			return true;
		return false;
	}

	private int diaAtual() {
		Calendar cal = Calendar.getInstance();
		int diaDoAno = cal.get(Calendar.DAY_OF_YEAR);
		int ano = cal.get(Calendar.YEAR);
		return diaDoAno * ano;
	}

	public int obterPrazoDevolucaoRelativoAHoje() {
		return dataDevolucao - diaAtual();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dataDevolucao;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrazoDevolucao other = (PrazoDevolucao) obj;
		if (dataDevolucao != other.dataDevolucao)
			return false;
		return true;
	}

}

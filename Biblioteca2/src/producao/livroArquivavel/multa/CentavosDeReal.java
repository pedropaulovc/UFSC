package producao.livroArquivavel.multa;

public class CentavosDeReal implements TipoCentavosDeReal {
	private int centavos;

	public CentavosDeReal(int centavos){
		this.centavos = centavos;
	}

	public String toString() {
		return centavos + "centavos de real";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + centavos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CentavosDeReal other = (CentavosDeReal) obj;
		if (centavos != other.centavos)
			return false;
		return true;
	}
	
	
	
}

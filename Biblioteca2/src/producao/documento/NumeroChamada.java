package producao.documento;

public class NumeroChamada implements TipoNumeroChamada {

	private String numeroChamada;

	public NumeroChamada(String numeroChamada) {
		this.numeroChamada = numeroChamada;
	}

	public String toString() {
		return numeroChamada;
	}


}

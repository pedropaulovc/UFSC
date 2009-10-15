package producao.documento;

public class NumeroChamadaConcreto implements NumeroChamada {

	private String numeroChamada;

	public NumeroChamadaConcreto(String numeroChamada) {
		this.numeroChamada = numeroChamada;
	}

	public String toString() {
		return numeroChamada;
	}


}

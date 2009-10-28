package producao.livro.exemplar.numeroChamada;

public class NumeroChamada implements TipoNumeroChamada {

	private String numeroChamada;

	public NumeroChamada(String numeroChamada) {
		this.numeroChamada = numeroChamada;
	}

	public String toString() {
		return numeroChamada;
	}


}

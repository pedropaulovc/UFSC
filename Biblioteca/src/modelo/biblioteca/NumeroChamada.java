package modelo.biblioteca;

public class NumeroChamada {
	private String numeroChamada;

	public NumeroChamada(String numeroChamada) {
		this.numeroChamada = numeroChamada;
	}

	public String toString() {
		return "Número de chamada: " + numeroChamada;
	}

	public NumeroChamada clone() {
		try {
			return (NumeroChamada) super.clone();
		} catch (CloneNotSupportedException e) {
			return this;
		}
	}
}

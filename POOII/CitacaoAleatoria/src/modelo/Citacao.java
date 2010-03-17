package modelo;

public class Citacao{
	private String citacao;

	public Citacao(String citacao){
		this.citacao = citacao;
	}
	
	public void modificarCitacao(String citacao) {
		this.citacao = citacao;
	}

	public String toString() {
		return citacao;
	}

	public Citacao clone() {
		return new Citacao(citacao);
	}
}

package modelo;

public class CitacaoNula implements InterfaceCitacao {

	@Override
	public CitacaoNula clone() {
		return new CitacaoNula();
	}

	@Override
	public void modificarCitacao(String citacao) { }

	@Override
	public String toString() {
		return "";
	}

}

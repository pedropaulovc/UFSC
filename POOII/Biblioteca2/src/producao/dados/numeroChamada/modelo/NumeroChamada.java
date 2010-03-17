package producao.dados.numeroChamada.modelo;

import static producao.dados.ValidadorString.validarStringNaoVazia;
import producao.dados.ExcecaoParametroInvalido;

public class NumeroChamada implements TipoNumeroChamada {

	private String numeroChamada;

	public NumeroChamada(String numeroChamada) throws ExcecaoParametroInvalido {
		if (!validarStringNaoVazia(numeroChamada))
			throw new ExcecaoParametroInvalido("Número de chamada vazio");
		this.numeroChamada = numeroChamada;
	}

	public String toString() {
		return numeroChamada;
	}

}

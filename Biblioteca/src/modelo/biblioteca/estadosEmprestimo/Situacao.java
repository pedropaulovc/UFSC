package modelo.biblioteca.estadosEmprestimo;

import util.AdaptadorDeString;

public enum Situacao {
	DISPONÍVEL, CONSULTA_LOCAL, EMPRESTADO, EM_RESTAURAÇÃO;

	public String toString() {
		return AdaptadorDeString.adaptarParaPrimeiraLetraMaiusculaComEspacos(super
				.toString());
	}
}

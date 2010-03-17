package modelo.biblioteca.arquivaveis;

import util.AdaptadorDeString;

public enum Arquivavel {
	LIVRO, REVISTA, TESE, TCC, DISSERTAÇÃO, GIBI, GUIA, MAPA;
	
	public String toString(){
		return AdaptadorDeString.adaptarParaPrimeiraLetraMaiusculaComEspacos(super.toString());
	}
}
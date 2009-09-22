package modelo.biblioteca.arquivaveis;

import modelo.biblioteca.Documento;

public class Livro extends Arquivavel {
	private int qtdCapitulos;
	
	public Livro(Documento documento, int qtdCapitulos) {
		super(documento);
		this.qtdCapitulos = qtdCapitulos;
	}
	
	public void alterarQtdCapitulos(int qtdCapitulos) {
		this.qtdCapitulos = qtdCapitulos;
	}

	public int obterQtdCapitulos() {
		return qtdCapitulos;
	}
	
	public String toString(){
		return super.toString() + " Possui " + qtdCapitulos + " capítulos.";
	}
	
	public Livro clone(){
		return new Livro(super.obterDocumento().clone(), qtdCapitulos);
	}
}

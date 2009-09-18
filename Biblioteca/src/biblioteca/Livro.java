package biblioteca;


public class Livro {
	private int qtdCapitulos;
	private Documento documentoOriginal;
	
	public Livro(Documento documentoOriginal, int qtdCapitulos) {
		this.alterarDocumentoOriginal(documentoOriginal);
		this.qtdCapitulos = qtdCapitulos;
	}
	
	public void alterarQtdCapitulos(int qtdCapitulos) {
		this.qtdCapitulos = qtdCapitulos;
	}

	public int obterQtdCapitulos() {
		return qtdCapitulos;
	}

	public void alterarDocumentoOriginal(Documento documentoOriginal) {
		this.documentoOriginal = documentoOriginal;
	}

	public Documento obterDocumentoOriginal() {
		return documentoOriginal;
	}
	
	public String toString(){
		return documentoOriginal.toString() + " Possui " + qtdCapitulos + "capítulos.";
	}
	
	public Livro clone(){
		try {
			return (Livro) super.clone();
		} catch (CloneNotSupportedException excecao) {
			return this;
		}
	}
}

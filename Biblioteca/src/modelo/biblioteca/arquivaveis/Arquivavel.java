package modelo.biblioteca.arquivaveis;

import modelo.biblioteca.Documento;

public abstract class Arquivavel {
	private Documento documento;
	
	public Arquivavel(Documento documento){
		this.documento = documento;
	}
	
	public void alterarDocumento(Documento documento) {
		this.documento = documento;
	}
	
	public Documento obterDocumento(){
		return documento.clone();
	}
		
	public String toString(){
		return documento.toString();
	}
	
	public Arquivavel clone(){
		try {
			return (Arquivavel) super.clone();
		} catch (CloneNotSupportedException excecao) {
			return this;
		}
	}
}

package modelo.biblioteca;

import modelo.biblioteca.estadosEmprestimo.Situacao;

public class Exemplar {
	private Situacao situacao;
	private String localizacao;
	
	public Exemplar(Situacao situacao, String localizacao){
		this.situacao = situacao;
		this.alterarLocalizacao(localizacao);
	}
	
	public void alterarSituacao(Situacao situacao){
		this.situacao = situacao;
	}

	public Situacao obterSituacao(){
		return situacao;
	}

	public void alterarLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String obterLocalizacao() {
		return localizacao;
	}
	
	public String toString(){
		return "Exemplar localizado em  " + localizacao + ". Situação: " + situacao;
	}
	
	public Exemplar clone(){
		try {
			return (Exemplar) super.clone();
		} catch (CloneNotSupportedException excecao) {
			return this;
		}
	}
}

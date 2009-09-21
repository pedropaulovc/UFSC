package biblioteca;

import biblioteca.situacoes.Situacao;

public class Exemplar {
	private Situacao situacao;
	private int volume;
	private String localizacao;
	
	public Exemplar(int volume, Situacao situacao, String localizacao){
		this.situacao = situacao;
		this.volume = volume;
		this.alterarLocalizacao(localizacao);
	}
	
	public void alterarSituacao(Situacao situacao){
		this.situacao = situacao;
	}

	public Situacao obterSituacao(){
		return situacao.clone();
	}
	
	public int obterVolume(){
		return volume;
	}
	
	public void alterarVolume(int volume){
		this.volume = volume;
	}
	

	public void alterarLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String obterLocalizacao() {
		return localizacao;
	}
	
	public String toString(){
		return "Volume " + volume + "; Situação: " + situacao;
	}
	
	public Exemplar clone(){
		try {
			return (Exemplar) super.clone();
		} catch (CloneNotSupportedException excecao) {
			return this;
		}
	}
}

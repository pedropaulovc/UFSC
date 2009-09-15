package biblioteca;

public class Exemplar implements Cloneable {
	private TipoSituacao situacao;
	private int volume;
	
	public Exemplar(int volume, TipoSituacao situacao){
		this.situacao = situacao;
		this.volume = volume;
	}
	
	public void alterarSituacao(TipoSituacao situacao){
		this.situacao = situacao;
	}
	
	public TipoSituacao obterSituacao(){
		return situacao;
	}
	
	public int obterVolume(){
		return volume;
	}
	
	public void alterarVolume(int volume){
		this.volume = volume;
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

package producao.dados.nome;

public class Nome implements TipoNome {
	private String nome;

	public Nome(String nome){
		this.nome = nome;
	}
	
	public String toString(){
		return nome;
	}
}


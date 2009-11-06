package producao.dados.nome.modelo;

public class Nome implements TipoNome {
	private String nome;

	public Nome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return nome;
	}
}

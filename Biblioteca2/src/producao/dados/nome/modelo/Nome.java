package producao.dados.nome.modelo;

public class Nome implements TipoNome {
	private String nome;

	public Nome(String nome) {
		assert nome.length() != 0;
		this.nome = nome;
	}

	public String toString() {
		return nome;
	}
}

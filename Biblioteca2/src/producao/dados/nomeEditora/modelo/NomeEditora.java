package producao.dados.nomeEditora.modelo;

public class NomeEditora implements TipoNomeEditora {

	private String editora;

	public NomeEditora(String editora) {
		assert editora.length() != 0;
		this.editora = editora;
	}

	public String toString() {
		return editora;
	}

}

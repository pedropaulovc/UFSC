package producao.dados.autor.modelo;

public class Autor implements TipoAutor {

	private String autor;

	public Autor(String autor) {
		assert autor.length() != 0;
		this.autor = autor;
	}

	public String toString() {
		return autor;
	}

}

package producao.dados.titulo.modelo;

public class Titulo implements TipoTitulo {

	private String titulo;

	public Titulo(String titulo) {
		assert titulo.length() != 0;
		this.titulo = titulo;
	}

	public String toString() {
		return titulo;
	}

}

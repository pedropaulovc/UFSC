package producao.livro.titulo;

public class Titulo implements TipoTitulo {

	private String titulo;

	public Titulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String toString(){
		return titulo;
	}

}

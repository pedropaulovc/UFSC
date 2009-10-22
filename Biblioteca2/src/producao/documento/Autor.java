package producao.documento;

public class Autor implements TipoAutor {

	private String autor;

	public Autor(String autor) {
		this.autor = autor;
	}
	
	public String toString(){
		return autor;
	}

}

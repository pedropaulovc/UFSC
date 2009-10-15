package producao.documento;

public class AutorConcreto implements Autor {

	private String autor;

	public AutorConcreto(String autor) {
		this.autor = autor;
	}
	
	public String toString(){
		return autor;
	}

}

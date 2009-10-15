package producao.documento;

public class TituloConcreto implements Titulo {

	private String titulo;

	public TituloConcreto(String titulo) {
		this.titulo = titulo;
	}
	
	public String toString(){
		return titulo;
	}

}

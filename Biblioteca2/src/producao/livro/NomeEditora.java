package producao.livro;

public class NomeEditora implements TipoNomeEditora {

	private String editora;

	public NomeEditora(String editora) {
		this.editora = editora;
	}
	
	public String toString(){
		return editora;
	}

}

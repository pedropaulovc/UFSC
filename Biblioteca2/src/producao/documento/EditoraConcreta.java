package producao.documento;

public class EditoraConcreta implements Editora {

	private String editora;

	public EditoraConcreta(String editora) {
		this.editora = editora;
	}

	public String toString(){
		return editora;
	}

}

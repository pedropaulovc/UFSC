package producao.ingrediente;

public class IngredienteNulo implements Ingrediente {

	public String obterIngrediente() {
		return "";
	}
	
	public boolean equals(Object outro){
		if(outro instanceof IngredienteNulo)
			return true;
		return false;
	}
}

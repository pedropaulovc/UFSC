package producao.ingrediente;

public abstract class IngredienteReal implements Ingrediente {
	private String ingrediente;

	public IngredienteReal(String ingrediente){
		this.ingrediente = ingrediente;
	}
	
	public String obterIngrediente(){
		return ingrediente;
	}
	
	@Override
	public boolean equals(Object outro){
		if(ingrediente.equals(((IngredienteReal) outro).obterIngrediente()))
			return true;
		return false;
	}
}

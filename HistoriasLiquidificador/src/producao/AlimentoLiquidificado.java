package producao;


public class AlimentoLiquidificado implements Alimento {

	private ListaDe<Ingrediente> listaIngredientes;

	public AlimentoLiquidificado(ListaDe<Ingrediente> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

	public ListaDe<Ingrediente> obterListaIngredientes() {
		return listaIngredientes.clone();
	}
	
	public boolean equals(Object outro){
		if(listaIngredientes.equals(outro))
			return true;
		return false;
	}
}

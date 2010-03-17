package producao.alimento;

import producao.ListaDe;
import producao.ingrediente.Ingrediente;

public abstract class AlimentoReal implements Alimento {
	private ListaDe<Ingrediente> listaIngredientes;

	public AlimentoReal(ListaDe<Ingrediente> listaIngredientes) {
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

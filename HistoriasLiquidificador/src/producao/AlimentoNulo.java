package producao;


public class AlimentoNulo implements Alimento {
	
	public ListaDe<Ingrediente> obterListaIngredientes() {
		return new ListaDe<Ingrediente>();
	}

	public boolean equals(Object outro){
		if(outro instanceof AlimentoNulo)
			return true;
		
		return false;
	}
}

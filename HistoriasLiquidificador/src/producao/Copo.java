package producao;


public class Copo {
	private Tampa tampa;
	private ListaDe<Ingrediente> listaIngredientes;
	
	public Copo(){
		tampa = new Tampa();
		listaIngredientes = new ListaDe<Ingrediente>();
	}
	
	public void travarTampa(){
		tampa.travar(this);
	}

	public void travar(Liquidificador liquidificador) {
		
	}

	public void adicionarIngrediente(Ingrediente ingrediente) {
		listaIngredientes.adicionar(ingrediente);
	}

	public ListaDe<Ingrediente> obterListaIngredientes() {
		return listaIngredientes.clone();
	}
}

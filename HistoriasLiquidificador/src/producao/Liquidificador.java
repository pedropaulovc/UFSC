package producao;


public class Liquidificador {
	Copo copo;
	
	public Liquidificador(){
		copo = new Copo();
	}
	
	public void encaixarCopo() {
		copo.travar(this);
	}

	public void ligarNaTomada() {
		
		
	}

	public void encaixarTampa() {
		
		
	}

	public void ligarVelocidade(int i) {
		
		
	}

	public Alimento obterLiquidificado() {
		ListaDe<Ingrediente> listaIngredientesNoCopo = copo.obterListaIngredientes();
		
		if(listaIngredientesNoCopo.tamanho() == 0)
			return new AlimentoNulo();
		
		if(háAlimentoNuloNosIngredientes())
			return new AlimentoNulo();
		
		return new AlimentoLiquidificado(listaIngredientesNoCopo);
		
	}

	private boolean háAlimentoNuloNosIngredientes() {
		ListaDe<Ingrediente> listaIngredientesNoCopo = copo.obterListaIngredientes();
		
		for(int i = 0; i < listaIngredientesNoCopo.tamanho(); i++)
			if(listaIngredientesNoCopo.obter(i) instanceof IngredienteNulo)
				return true;
		return false;
	}

	public void adicionarIngrediente(Ingrediente ingrediente) {
		copo.adicionarIngrediente(ingrediente);
	}
	
}

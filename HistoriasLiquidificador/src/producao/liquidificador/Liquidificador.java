package producao.liquidificador;

import producao.ListaDe;
import producao.alimento.Alimento;
import producao.alimento.AlimentoLiquidificado;
import producao.alimento.AlimentoNulo;
import producao.ingrediente.Ingrediente;
import producao.ingrediente.IngredienteDuro;
import producao.ingrediente.IngredienteMacio;
import producao.ingrediente.IngredienteNulo;

public class Liquidificador {
	Copo copo;
	private int velocidade;

	public Liquidificador() {
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
		this.velocidade = i;
	}

	public Alimento obterLiquidificado() {
		ListaDe<Ingrediente> listaIngredientesNoCopo = copo
				.obterListaIngredientes();

		if (!háIngredientesNoCopo() || háIngredientesNulosNoCopo())
			return new AlimentoNulo();

		if (háIngredientesDurosNoCopo() && velocidade > 4)
			return new AlimentoLiquidificado(listaIngredientesNoCopo);

		if (!háIngredientesDurosNoCopo() && velocidade > 2)
			return new AlimentoLiquidificado(listaIngredientesNoCopo);

		if (háSomenteIngredientesMaciosNoCopo())
			return new AlimentoLiquidificado(listaIngredientesNoCopo);

		return new AlimentoNulo();
	}

	private boolean háSomenteIngredientesMaciosNoCopo() {
		ListaDe<Ingrediente> ingredientesNoCopo = copo.obterListaIngredientes();

		for (int i = 0; i < ingredientesNoCopo.tamanho(); i++)
			if (!(ingredientesNoCopo.obter(i) instanceof IngredienteMacio))
				return false;
		return true;
	}

	private boolean háIngredientesDurosNoCopo() {
		ListaDe<Ingrediente> ingredientesNoCopo = copo.obterListaIngredientes();

		for (int i = 0; i < ingredientesNoCopo.tamanho(); i++)
			if (ingredientesNoCopo.obter(i) instanceof IngredienteDuro)
				return true;
		return false;
	}

	private boolean háIngredientesNoCopo() {
		if (copo.obterListaIngredientes().tamanho() == 0)
			return false;
		return true;
	}

	private boolean háIngredientesNulosNoCopo() {
		ListaDe<Ingrediente> ingredientesNoCopo = copo.obterListaIngredientes();

		for (int i = 0; i < ingredientesNoCopo.tamanho(); i++)
			if (ingredientesNoCopo.obter(i) instanceof IngredienteNulo)
				return true;
		return false;
	}

	public void adicionarIngrediente(Ingrediente ingrediente) {
		copo.adicionarIngrediente(ingrediente);
	}

	public void desligar() {
		// TODO Auto-generated method stub

	}

}

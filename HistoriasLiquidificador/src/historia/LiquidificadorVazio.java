package historia;

import org.junit.Test;

import junit.framework.Assert;
import producao.AlimentoNulo;
import producao.IngredienteNulo;
import producao.Liquidificador;
import infra.Cenario;

public class LiquidificadorVazio extends Cenario {

	private Liquidificador liquidificador;

	@Override
	public void dadoQue() {
		existeUmLiquidificador();
		liquidificadorEstáLigadoNaTomada();
		oCopoEstáEncaixado();
		nãoHáIngredientesNoCopo();
		aTampaEstáTravada();
	}

	public void quando() {
		éEscolhidaQualquerVelocidade();
	}

	public void então() {
		nãoHáAlimentoLiquidificado();
	}

	private void existeUmLiquidificador() {
		liquidificador = new Liquidificador();

	}

	private void liquidificadorEstáLigadoNaTomada() {
		liquidificador.ligarNaTomada();

	}

	private void oCopoEstáEncaixado() {
		liquidificador.encaixarCopo();
	}

	private void nãoHáIngredientesNoCopo() {
		liquidificador.adicionarIngrediente(new IngredienteNulo());
	}

	private void aTampaEstáTravada() {
		liquidificador.encaixarTampa();

	}

	private void éEscolhidaQualquerVelocidade() {
		liquidificador.ligarVelocidade(4);
	}

	@Test
	public void nãoHáAlimentoLiquidificado() {
		Assert.assertTrue(liquidificador.obterLiquidificado() instanceof AlimentoNulo);
	}

}

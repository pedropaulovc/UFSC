package historia;

import infra.Cenario;
import junit.framework.Assert;

import org.junit.Test;

import producao.AlimentoLiquidificado;
import producao.Ingrediente;
import producao.IngredienteNulo;
import producao.IngredienteReal;
import producao.Liquidificador;

public class LiquidificadorComAlimentoMacio extends Cenario {

	private Liquidificador liquidificador;

	@Override
	public void dadoQue() {
		existeUmLiquidificador();
		liquidificadorEstáLigadoNaTomada();
		oCopoEstáEncaixado();
		HáIngredientesMaciosNoCopo();
		aTampaEstáTravada();
	}

	public void quando() {
		éEscolhidaVelocidade1();
	}

	public void então() {
		háAlimentoLiquidificado();
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

	private void HáIngredientesMaciosNoCopo() {
		liquidificador.adicionarIngrediente(new IngredienteReal("banana"));
	}

	private void aTampaEstáTravada() {
		liquidificador.encaixarTampa();

	}

	private void éEscolhidaVelocidade1() {
		liquidificador.ligarVelocidade(1);
	}

	@Test
	public void háAlimentoLiquidificado() {
		Assert.assertTrue(liquidificador.obterLiquidificado() instanceof AlimentoLiquidificado);
	}
}

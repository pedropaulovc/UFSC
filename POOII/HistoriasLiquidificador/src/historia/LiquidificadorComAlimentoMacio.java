package historia;

import infra.Cenario;
import junit.framework.Assert;

import org.junit.Test;

import producao.alimento.AlimentoLiquidificado;
import producao.ingrediente.IngredienteMacio;
import producao.liquidificador.Liquidificador;

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
		éEscolhidaVelocidade1Ou2();
		éDesligadoOLiquidificador();
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
		liquidificador.adicionarIngrediente(new IngredienteMacio("banana"));
	}

	private void aTampaEstáTravada() {
		liquidificador.encaixarTampa();

	}

	private void éEscolhidaVelocidade1Ou2() {
		liquidificador.ligarVelocidade(2);
	}

	private void éDesligadoOLiquidificador() {
		liquidificador.desligar();
	}

	@Test
	public void háAlimentoLiquidificado() {
		Assert
				.assertTrue(liquidificador.obterLiquidificado() instanceof AlimentoLiquidificado);
	}
}

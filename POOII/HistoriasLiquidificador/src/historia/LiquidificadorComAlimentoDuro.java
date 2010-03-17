package historia;

import infra.Cenario;
import junit.framework.Assert;

import org.junit.Test;

import producao.alimento.AlimentoLiquidificado;
import producao.ingrediente.IngredienteDuro;
import producao.liquidificador.Liquidificador;

public class LiquidificadorComAlimentoDuro extends Cenario {

	private Liquidificador liquidificador;

	@Override
	public void dadoQue() {
		existeUmLiquidificador();
		liquidificadorEstáLigadoNaTomada();
		oCopoEstáEncaixado();
		HáIngredientesMédiosNoCopo();
		aTampaEstáTravada();
	}

	public void quando() {
		éEscolhidaVelocidade5();
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

	private void HáIngredientesMédiosNoCopo() {
		liquidificador.adicionarIngrediente(new IngredienteDuro("gelo"));
	}

	private void aTampaEstáTravada() {
		liquidificador.encaixarTampa();

	}

	private void éEscolhidaVelocidade5() {
		liquidificador.ligarVelocidade(5);
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

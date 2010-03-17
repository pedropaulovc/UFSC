package historia;

import infra.Cenario;
import junit.framework.Assert;

import org.junit.Test;

import producao.alimento.AlimentoLiquidificado;
import producao.ingrediente.IngredienteMedio;
import producao.liquidificador.Liquidificador;

public class LiquidificadorComAlimentoMedio extends Cenario {

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
		éEscolhidaVelocidade3Ou4();
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
		liquidificador.adicionarIngrediente(new IngredienteMedio("tomate"));
	}

	private void aTampaEstáTravada() {
		liquidificador.encaixarTampa();

	}

	private void éEscolhidaVelocidade3Ou4() {
		liquidificador.ligarVelocidade(3);
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

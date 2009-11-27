package historia.dados;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import infra.Cenario;

import org.junit.Test;

import producao.dados.prazoDevolucao.PrazoDevolucao;

public class CriarPrazoDevolucao extends Cenario {

	private PrazoDevolucao pD;
	private int prazo;

	public void dadoQue() {
		existeUmPrazoVálido();
	}

	public void quando() {
		criaUmNovoPrazoDevolução();
	}

	public void então() {
		recebeUmNovoPrazoDevolução();
	}

	private void existeUmPrazoVálido() {
		this.prazo = 10;
	}

	private void criaUmNovoPrazoDevolução() {
		this.pD = new PrazoDevolucao(prazo);
	}

	@Test
	public void recebeUmNovoPrazoDevolução() {
		assertNotNull(prazo);
		assertEquals(Integer.toString(prazo), pD.toString());
	}

}
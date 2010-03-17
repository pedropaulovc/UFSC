package historia.dados;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import infra.Cenario;

import org.junit.Test;

import producao.dados.numeroChamada.modelo.NumeroChamada;

public class CriarNumeroChamada extends Cenario {

	private NumeroChamada nc;
	private String num;

	public void dadoQue() {
		existeUmNúmeroChamadaVálido();
	}

	public void quando() {
		criaUmNovoNúmeroChamada();
	}

	public void então() {
		recebeUmNovoNúmeroChamada();
	}

	private void existeUmNúmeroChamadaVálido() {
		this.num = "12234.22(23)";
	}

	private void criaUmNovoNúmeroChamada() {
		this.nc = new NumeroChamada(num);
	}

	@Test
	public void recebeUmNovoNúmeroChamada() {
		assertNotNull(nc);
		assertEquals(num, nc.toString());
	}

}
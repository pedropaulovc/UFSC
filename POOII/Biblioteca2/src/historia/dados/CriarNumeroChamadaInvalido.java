package historia.dados;

import static org.junit.Assert.assertNull;
import infra.Cenario;

import org.junit.Test;

import producao.dados.ExcecaoParametroInvalido;
import producao.dados.numeroChamada.modelo.NumeroChamada;

public class CriarNumeroChamadaInvalido extends Cenario {

	private NumeroChamada nc;
	private String num;

	public void dadoQue() {
		existeUmNúmeroChamadaInválido();
	}

	public void quando() {
		try {criaUmNovoNúmeroChamada();} catch (Exception e) {}
	}

	public void então() {
		recebeUmNovoNúmeroChamada();
	}

	private void existeUmNúmeroChamadaInválido() {
		this.num = "";
	}

	@Test(expected = ExcecaoParametroInvalido.class)
	public void criaUmNovoNúmeroChamada() {
		this.nc = new NumeroChamada(num);
	}

	@Test
	public void recebeUmNovoNúmeroChamada() {
		assertNull(nc);
	}

}
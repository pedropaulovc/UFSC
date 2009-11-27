package historia.dados;

import static org.junit.Assert.assertNull;
import infra.Cenario;

import org.junit.Test;

import producao.dados.ExcecaoParametroInvalido;
import producao.dados.prazoDevolucao.PrazoDevolucao;

public class CriarPrazoDevolucaoInvalido extends Cenario {

	private PrazoDevolucao pD;
	private int prazo;

	public void dadoQue() {
		existeUmPrazoInválido();
	}

	public void quando() {
		try {criaUmNovoPrazoDevolução();} catch (Exception e) {}
	}

	public void então() {
		recebeErro();
	}

	private void existeUmPrazoInválido() {
		this.prazo = -10;
	}

	@Test(expected = ExcecaoParametroInvalido.class)
	public void criaUmNovoPrazoDevolução() {
		this.pD = new PrazoDevolucao(prazo);
	}

	@Test
	public void recebeErro() {
		assertNull(pD);
	}

}
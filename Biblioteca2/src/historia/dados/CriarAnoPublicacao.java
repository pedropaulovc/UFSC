package historia.dados;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import infra.Cenario;

import org.junit.Test;

import producao.dados.anoPublicacao.modelo.AnoPublicacao;

public class CriarAnoPublicacao extends Cenario {

	private int data;
	private AnoPublicacao anoPublicacao;

	public void dadoQue() {
		existeUmaDataVálida();
	}

	public void quando() {
		criaUmNovoAnoDePublicação();
	}

	public void então() {
		recebeUmNovoAnoDePublicação();
	}

	private void existeUmaDataVálida() {
		this.data = 1999;
	}

	private void criaUmNovoAnoDePublicação() {
		this.anoPublicacao = new AnoPublicacao(data);
	}

	@Test
	public void recebeUmNovoAnoDePublicação() {
		assertNotNull(anoPublicacao);
		assertEquals(Integer.toString(data), anoPublicacao.toString());
	}

}
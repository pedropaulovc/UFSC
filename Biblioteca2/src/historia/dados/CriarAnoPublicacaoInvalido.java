package historia.dados;

import static org.junit.Assert.assertNull;
import infra.Cenario;

import org.junit.Test;

import producao.dados.ExcecaoParametroInvalido;
import producao.dados.anoPublicacao.modelo.AnoPublicacao;

public class CriarAnoPublicacaoInvalido extends Cenario {

	private int data;
	private AnoPublicacao anoPublicacao;

	public void dadoQue() {
		existeUmaDataInválida();
	}

	public void quando() {
		//tentaCriarUmNovoAnoDePublicação();
	}

	public void então() {
		recebeErro();
	}

	private void existeUmaDataInválida() {
		this.data = -2;
	}

	@Test(expected = ExcecaoParametroInvalido.class)
	public void tentaCriarUmNovoAnoDePublicação() {
		anoPublicacao = new AnoPublicacao(data);
	}
	
	@Test
	public void recebeErro() {
		assertNull(anoPublicacao);
	}

}

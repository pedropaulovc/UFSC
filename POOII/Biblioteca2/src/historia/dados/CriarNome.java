package historia.dados;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import infra.Cenario;

import org.junit.Test;

import producao.dados.nome.modelo.Nome;

public class CriarNome extends Cenario {

	private Nome nome;
	private String sNome;

	public void dadoQue() {
		existeUmNomeVálido();
	}

	public void quando() {
		criaUmNovoNome();
	}

	public void então() {
		recebeUmNovoNome();
	}

	private void existeUmNomeVálido() {
		this.sNome = "Título";
	}

	private void criaUmNovoNome() {
		this.nome = new Nome(sNome);
	}

	@Test
	public void recebeUmNovoNome() {
		assertNotNull(nome);
		assertEquals(sNome, nome.toString());
	}

}
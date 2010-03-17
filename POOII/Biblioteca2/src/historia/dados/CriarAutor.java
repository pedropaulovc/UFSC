package historia.dados;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import infra.Cenario;

import org.junit.Test;

import producao.dados.autor.modelo.Autor;

public class CriarAutor extends Cenario {

	private Autor autor;
	private String sAutor;

	public void dadoQue() {
		existeUmAutorVálido();
	}

	public void quando() {
		criaUmNovoAutor();
	}

	public void então() {
		recebeUmNovoAutor();
	}

	private void existeUmAutorVálido() {
		this.sAutor = "Autor";
	}

	private void criaUmNovoAutor() {
		this.autor = new Autor(sAutor);
	}

	@Test
	public void recebeUmNovoAutor() {
		assertNotNull(autor);
		assertEquals(sAutor, autor.toString());
	}

}
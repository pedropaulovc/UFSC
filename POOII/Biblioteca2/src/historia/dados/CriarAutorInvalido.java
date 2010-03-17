package historia.dados;

import static org.junit.Assert.assertNull;
import infra.Cenario;

import org.junit.Test;

import producao.dados.ExcecaoParametroInvalido;
import producao.dados.autor.modelo.Autor;

public class CriarAutorInvalido extends Cenario {

	private Autor autor;
	private String sAutor;

	public void dadoQue() {
		existeUmAutorInválido();
	}

	public void quando() {
		try {criaUmNovoAutor();} catch (Exception e) {}
	}

	public void então() {
		recebeErro();
	}

	private void existeUmAutorInválido() {
		this.sAutor = "";
	}

	@Test(expected = ExcecaoParametroInvalido.class)
	public void criaUmNovoAutor() {
		this.autor = new Autor(sAutor);
	}

	@Test
	public void recebeErro() {
		assertNull(autor);
	}

}
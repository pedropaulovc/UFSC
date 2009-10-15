package historia;

import junit.framework.Assert;

import org.junit.Test;

import producao.Biblioteca;

import infra.Cenario;

public class CriarBiblioteca extends Cenario {

	private Biblioteca biblioteca;

	public void dadoQue() {

	}

	public void quando() {
		crioUmaBiblioteca();
	}

	public void então() {
		bibliotecaPassaAExistir();
	}

	private void crioUmaBiblioteca() {
		biblioteca = new Biblioteca();
	}

	@Test
	public void bibliotecaPassaAExistir() {
		Assert.assertNotNull(biblioteca);
	}
}

package historia;

import static junit.framework.Assert.*;

import org.junit.Test;

import producao.Biblioteca;
import producao.ConfiguracaoBiblioteca;
import producao.TipoBiblioteca;
import producao.TipoConfiguracaoBiblioteca;

import infra.Cenario;

public class CriarBiblioteca extends Cenario {

	private TipoBiblioteca b;
	private TipoConfiguracaoBiblioteca configuração;

	public void dadoQue() {
		existemConfiguraçõesValidasBiblioteca();
	}

	public void quando() {
		crioUmaBiblioteca();
	}

	public void então() {
		bibliotecaPassaAExistir();
		bibliotecaPossuiUmNome();
		bibliotecaPossuiNenhumLivroNoAcervo();
	}

	private void existemConfiguraçõesValidasBiblioteca() {
		configuração = new ConfiguracaoBiblioteca("Biblioteca Central;15");
	}
	
	private void crioUmaBiblioteca() {
		b = new Biblioteca(configuração);
	}
	
	@Test
	public void bibliotecaPassaAExistir() {
		assertNotNull(b);
	}
	
	@Test
	public void bibliotecaPossuiUmNome() {
		assertEquals("Biblioteca Central", b.obterNome().toString());
	}
	
	@Test
	public void bibliotecaPossuiNenhumLivroNoAcervo() {
		assertEquals(0, b.tamanho());
	}
}

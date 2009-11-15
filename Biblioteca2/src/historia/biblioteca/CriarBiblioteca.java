package historia.biblioteca;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import infra.Cenario;

import org.junit.Test;

import producao.biblioteca.configuracao.ConfiguracaoBiblioteca;
import producao.biblioteca.configuracao.TipoConfiguracaoBiblioteca;
import producao.biblioteca.modelo.Biblioteca;
import producao.biblioteca.modelo.TipoBiblioteca;
import producao.dados.nome.modelo.Nome;
import producao.dados.prazoDevolucao.PrazoDevolucao;

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
		configuração = new ConfiguracaoBiblioteca(
				new Nome("Biblioteca Central"), new PrazoDevolucao(15));
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

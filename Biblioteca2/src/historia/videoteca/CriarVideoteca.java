package historia.videoteca;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import infra.Cenario;

import org.junit.Test;

import producao.dados.nome.Nome;
import producao.dados.prazoDevolucao.PrazoDevolucao;
import producao.videoteca.TipoVideoteca;
import producao.videoteca.Videoteca;
import producao.videoteca.configuracao.ConfiguracaoVideoteca;
import producao.videoteca.configuracao.TipoConfiguracaoVideoteca;

public class CriarVideoteca extends Cenario {

	private TipoVideoteca v;
	private TipoConfiguracaoVideoteca configuração;

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
		configuração = new ConfiguracaoVideoteca(
				new Nome("Videoteca Nova"), new PrazoDevolucao(15));
	}

	private void crioUmaBiblioteca() {
		v = new Videoteca(configuração);
	}

	@Test
	public void bibliotecaPassaAExistir() {
		assertNotNull(v);
	}

	@Test
	public void bibliotecaPossuiUmNome() {
		assertEquals("Videoteca Nova", v.obterNome().toString());
	}

	@Test
	public void bibliotecaPossuiNenhumLivroNoAcervo() {
		assertEquals(0, v.tamanho());
	}
}

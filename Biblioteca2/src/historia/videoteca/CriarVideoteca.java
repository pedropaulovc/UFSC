package historia.videoteca;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import infra.Cenario;

import org.junit.Test;

import producao.dados.nome.modelo.Nome;
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
		crioUmaVideoteca();
	}

	public void então() {
		videotecaPassaAExistir();
		videotecaPossuiUmNome();
		videotecaPossuiNenhumLivroNoAcervo();
	}

	private void existemConfiguraçõesValidasBiblioteca() {
		configuração = new ConfiguracaoVideoteca(
				new Nome("Biblioteca Central"), new PrazoDevolucao(15));
	}

	private void crioUmaVideoteca() {
		v = new Videoteca(configuração);
	}

	@Test
	public void videotecaPassaAExistir() {
		assertNotNull(v);
	}

	@Test
	public void videotecaPossuiUmNome() {
		assertEquals("Biblioteca Central", v.obterNome().toString());
	}

	@Test
	public void videotecaPossuiNenhumLivroNoAcervo() {
		assertEquals(0, v.tamanho());
	}
}

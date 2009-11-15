package historia.videoteca;

import static org.junit.Assert.assertTrue;
import infra.CenarioComVideoteca;

import org.junit.Test;

import producao.dados.id.Id;
import producao.video.VideoNulo;
import producao.videoteca.TipoVideoteca;

public class ObterVideoInexistente extends CenarioComVideoteca {
	private TipoVideoteca b;

	public void dadoQue() {
		existeUmaBiblioteca();
	}

	public void quando() {
		obtemDadosDeUmLivroInexistente();
	}

	public void então() {
		nãoRecebeLivro();
	}

	private void existeUmaBiblioteca() {
		b = obterVideoteca();
	}

	public void obtemDadosDeUmLivroInexistente() {
	}

	@Test
	public void nãoRecebeLivro() {
		assertTrue(b.obter(new Id()) instanceof VideoNulo);
	}
}

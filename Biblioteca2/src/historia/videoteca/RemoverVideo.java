package historia.videoteca;

import static org.junit.Assert.assertEquals;
import infra.CenarioComVideoteca;

import org.junit.Test;

import producao.dados.id.TipoId;
import producao.videoteca.TipoVideoteca;

public class RemoverVideo extends CenarioComVideoteca {
	private TipoVideoteca b;
	private TipoId id;

	public void dadoQue() {
		existeUmaBibliotecaComUmLivro();
	}

	public void quando() {
		removeOLivro();
	}

	public void então() {
		bibliotecaFicaComNenhumLivro();
	}

	private void existeUmaBibliotecaComUmLivro() {
		b = obterVideoteca();

		id = b.adicionar(obterVideo());

		assertEquals(1, b.tamanho());
	}

	private void removeOLivro() {
		b.removerDocumento(id);
	}

	@Test
	public void bibliotecaFicaComNenhumLivro() {
		assertEquals(0, b.tamanho());
	}
}

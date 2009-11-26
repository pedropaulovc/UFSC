package historia.videoteca;

import static org.junit.Assert.assertEquals;
import infra.CenarioComVideoteca;

import org.junit.Test;

import producao.dados.id.Id;
import producao.videoteca.modelo.Videoteca;

public class RemoverVideoInexistente extends CenarioComVideoteca {
	private Videoteca b;

	public void dadoQue() {
		existeUmaBibliotecaComUmVideo();
	}

	public void quando() {
		removeVideoInexistente();
	}

	public void então() {
		bibliotecaContinuaComUmVideo();
	}

	private void existeUmaBibliotecaComUmVideo() {
		b = obterVideoteca();

		b.adicionar(obterVideo());

		assertEquals(1, b.tamanho());
	}

	private void removeVideoInexistente() {
		b.removerDocumento(new Id());
	}

	@Test
	public void bibliotecaContinuaComUmVideo() {
		assertEquals(1, b.tamanho());
	}
}

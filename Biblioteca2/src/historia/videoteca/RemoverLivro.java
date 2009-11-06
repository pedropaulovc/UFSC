package historia.videoteca;

import static org.junit.Assert.assertEquals;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.TipoBiblioteca;
import producao.dados.id.TipoId;

public class RemoverLivro extends CenarioComBiblioteca {
	private TipoBiblioteca b;
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
		b = obterBiblioteca();

		id = b.adicionarLivro(obterLivro());

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

package historia;

import static org.junit.Assert.assertEquals;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.TipoBiblioteca;
import producao.livro.id.TipoIdLivro;

public class RemoverLivro extends CenarioComBiblioteca {
	private TipoBiblioteca b;
	private TipoIdLivro id;

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

		id = b.adicionar(obterLivro());

		assertEquals(1, b.tamanho());
	}
	
	private void removeOLivro() {
		b.removerLivro(id);
	}

	@Test
	public void bibliotecaFicaComNenhumLivro() {
		assertEquals(0, b.tamanho());
	}
}

package historia;

import static org.junit.Assert.assertTrue;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.TipoBiblioteca;
import producao.livro.LivroNulo;
import producao.livro.id.IdLivro;

public class ObterLivroInexistente extends CenarioComBiblioteca {
	private TipoBiblioteca b;

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
		b = obterBiblioteca();
	}

	public void obtemDadosDeUmLivroInexistente() {}

	@Test
	public void nãoRecebeLivro() {
		assertTrue(b.obterLivro(new IdLivro()) instanceof LivroNulo);
	}
}

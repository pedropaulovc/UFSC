package historia.videoteca;

import static org.junit.Assert.assertTrue;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.TipoBiblioteca;
import producao.dados.id.Id;
import producao.livro.LivroNulo;

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

	public void obtemDadosDeUmLivroInexistente() {
	}

	@Test
	public void nãoRecebeLivro() {
		assertTrue(b.obterLivro(new Id()) instanceof LivroNulo);
	}
}

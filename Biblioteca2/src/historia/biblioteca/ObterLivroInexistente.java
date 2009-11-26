package historia.biblioteca;

import static org.junit.Assert.assertTrue;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.modelo.Biblioteca;
import producao.dados.id.Id;
import producao.livro.LivroNulo;

public class ObterLivroInexistente extends CenarioComBiblioteca {
	private Biblioteca b;

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
		assertTrue(b.obter(new Id()) instanceof LivroNulo);
	}
}

package historia.biblioteca;

import static org.junit.Assert.assertEquals;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.modelo.Biblioteca;
import producao.dados.id.Id;

public class RemoverLivroInexistente extends CenarioComBiblioteca {
	private Biblioteca b;

	public void dadoQue() {
		existeUmaBibliotecaComUmLivro();
	}

	public void quando() {
		removeLivroInexistente();
	}

	public void então() {
		bibliotecaContinuaComUmLivro();
	}

	private void existeUmaBibliotecaComUmLivro() {
		b = obterBiblioteca();

		b.adicionar(obterLivro());

		assertEquals(1, b.tamanho());
	}

	private void removeLivroInexistente() {
		b.removerDocumento(new Id());
	}

	@Test
	public void bibliotecaContinuaComUmLivro() {
		assertEquals(1, b.tamanho());
	}
}

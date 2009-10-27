package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.biblioteca.Biblioteca;
import producao.biblioteca.TipoBiblioteca;
import producao.biblioteca.configuracao.ConfiguracaoBiblioteca;
import producao.livro.dados.DadosLivro;
import producao.livro.id.IdLivro;

public class RemoverLivroInexistente extends Cenario {
	private TipoBiblioteca b;

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
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central;15"));

		b.adicionar(new DadosLivro("Nome do Título;Nome do Autor"));

		assertEquals(1, b.tamanho());
	}
	
	private void removeLivroInexistente() {
		b.removerLivro(new IdLivro());
	}

	@Test
	public void bibliotecaContinuaComUmLivro() {
		assertEquals(1, b.tamanho());
	}
}

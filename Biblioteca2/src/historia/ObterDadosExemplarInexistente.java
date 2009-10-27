package historia;

import infra.Cenario;

import java.security.InvalidParameterException;

import org.junit.Test;

import producao.biblioteca.Biblioteca;
import producao.biblioteca.TipoBiblioteca;
import producao.biblioteca.configuracao.ConfiguracaoBiblioteca;
import producao.livro.id.IdLivro;

public class ObterDadosExemplarInexistente extends Cenario {
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
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central;15"));
	}

	public void obtemDadosDeUmLivroInexistente() {}

	@Test (expected = InvalidParameterException.class)
	public void nãoRecebeLivro() {
		b.obterDadosLivro(new IdLivro());
	}
}

package historia;

import infra.Cenario;

import java.security.InvalidParameterException;

import org.junit.Test;

import producao.biblioteca.Biblioteca;
import producao.biblioteca.TipoBiblioteca;
import producao.biblioteca.configuracao.ConfiguracaoBiblioteca;
import producao.livro.exemplar.id.IdExemplar;

public class ObterDadosLivroInexistente extends Cenario {
	private TipoBiblioteca b;

	public void dadoQue() {
		existeUmaBiblioteca();
	}

	public void quando() {
		obtemDadosDeUmExemplarInexistente();
	}

	public void então() {
		nãoRecebeExemplar();
	}

	private void existeUmaBiblioteca() {
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central;15"));
	}

	public void obtemDadosDeUmExemplarInexistente() {}

	@Test (expected = InvalidParameterException.class)
	public void nãoRecebeExemplar() {
		b.obterDadosExemplar(new IdExemplar());
	}
}

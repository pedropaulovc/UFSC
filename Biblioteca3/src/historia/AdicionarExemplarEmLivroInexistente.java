package historia;

import infra.Cenario;

import java.security.InvalidParameterException;

import org.junit.Test;

import producao.biblioteca.Biblioteca;
import producao.biblioteca.TipoBiblioteca;
import producao.biblioteca.configuracao.ConfiguracaoBiblioteca;
import producao.livro.exemplar.dados.DadosExemplarArquivavel;
import producao.livro.exemplar.dados.TipoDadosExemplarArquivavel;
import producao.livro.id.IdLivro;

public class AdicionarExemplarEmLivroInexistente extends Cenario {
	private TipoDadosExemplarArquivavel dadosExemplar;
	private TipoBiblioteca b;

	public void dadoQue() {
		existeUmaBiblioteca();
	}

	public void quando() {
		adicionaExemplarALivroInexistente();
	}

	public void então() {
		nãoHáExemplar();
	}

	private void existeUmaBiblioteca() {
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central;15"));
	}

	private void adicionaExemplarALivroInexistente() {
	}

	@Test(expected = InvalidParameterException.class)
	public void nãoHáExemplar() {
		dadosExemplar = new DadosExemplarArquivavel(
				"Editora;1999;Numero Chamada");
		b.adicionarExemplar(new IdLivro(), dadosExemplar);
	}

}

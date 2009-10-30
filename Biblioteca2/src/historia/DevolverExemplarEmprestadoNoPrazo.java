package historia;

import static org.junit.Assert.assertEquals;
import static producao.livro.exemplar.EstadoEmprestimo.DISPONÍVEL;
import infra.Cenario;

import org.junit.Test;

import producao.biblioteca.Biblioteca;
import producao.biblioteca.TipoBiblioteca;
import producao.biblioteca.configuracao.ConfiguracaoBiblioteca;
import producao.livro.dados.DadosLivro;
import producao.livro.exemplar.dados.DadosExemplarArquivavel;
import producao.livro.exemplar.id.TipoIdExemplar;
import producao.livro.id.TipoIdLivro;

public class DevolverExemplarEmprestadoNoPrazo extends Cenario {
	private TipoBiblioteca b;
	private TipoIdLivro idLivro;
	private TipoIdExemplar idExemplar;

	public void dadoQue() {
		existeUmaBiblioteca();
		aBibliotecaPossuiUmLivro();
		oLivroPossuiUmExemplar();
		oExemplarEstáEmprestado();
	}

	public void quando() {
		devolverOExemplarNoPrazo();
	}

	public void então() {
		oExemplarFicaráDisponível();
		oPrazoDeDevolucaoÉZero();
	}

	private void existeUmaBiblioteca() {
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central;15"));
	}

	private void aBibliotecaPossuiUmLivro() {
		idLivro = b.adicionar(new DadosLivro("Nome Livro;Autor"));
	}

	private void oLivroPossuiUmExemplar() {
		idExemplar = b.adicionarExemplar(idLivro, new DadosExemplarArquivavel(
				"Editora;1999;Numero Chamada"));
	}

	private void oExemplarEstáEmprestado() {
		b.emprestar(idExemplar);
	}

	private void devolverOExemplarNoPrazo() {
		b.devolver(idExemplar);
	}

	@Test
	public void oExemplarFicaráDisponível() {
		assertEquals(DISPONÍVEL, b.obterEstadoLivro(idExemplar));
	}

	@Test
	public void oPrazoDeDevolucaoÉZero() {
		assertEquals(0, b.obterPrazoDevolucao(idExemplar)
				.obterPrazoDevolucaoRelativoAHoje());
	}
}

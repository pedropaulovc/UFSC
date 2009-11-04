package historia;

import static org.junit.Assert.assertEquals;
import static producao.livro.EstadoEmprestimo.DISPONÍVEL;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.TipoBiblioteca;
import producao.dados.id.TipoId;

public class DevolverLivroEmprestadoNoPrazo extends CenarioComBiblioteca {
	private TipoBiblioteca b;
	private TipoId idLivro;

	public void dadoQue() {
		existeUmaBiblioteca();
		aBibliotecaPossuiUmLivro();
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
		b = obterBiblioteca();
	}

	private void aBibliotecaPossuiUmLivro() {
		idLivro = b.adicionar(obterLivro());
	}

	private void oExemplarEstáEmprestado() {
		b.emprestar(idLivro);
	}

	private void devolverOExemplarNoPrazo() {
		b.devolver(idLivro);
	}

	@Test
	public void oExemplarFicaráDisponível() {
		assertEquals(DISPONÍVEL, b.obterEstadoLivro(idLivro));
	}

	@Test
	public void oPrazoDeDevolucaoÉZero() {
		assertEquals(0, b.obterPrazoDevolucao(idLivro)
				.obterPrazoDevolucaoRelativoAHoje());
	}
}

package historia.biblioteca;

import static org.junit.Assert.assertEquals;
import static producao.documento.arquivavel.EstadoEmprestimo.DISPONÍVEL;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.modelo.Biblioteca;
import producao.dados.id.TipoId;

public class DevolverLivroEmprestadoNoPrazo extends CenarioComBiblioteca {
	private Biblioteca b;
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
		assertEquals(DISPONÍVEL, b.obterEstadoDocumento(idLivro));
	}

	@Test
	public void oPrazoDeDevolucaoÉZero() {
		assertEquals(0, b.obterPrazoDevolucao(idLivro)
				.obterPrazoDevolucaoRelativoAHoje());
	}
}

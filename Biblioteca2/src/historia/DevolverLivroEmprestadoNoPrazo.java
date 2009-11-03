package historia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static producao.livroArquivavel.emprestimo.EstadoEmprestimo.DISPONÍVEL;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.TipoBiblioteca;
import producao.dados.id.TipoId;
import producao.livroArquivavel.devolucao.TipoDevolucao;
import producao.livroArquivavel.multa.CentavosDeReal;
import producao.livroArquivavel.multa.Multa;

public class DevolverLivroEmprestadoNoPrazo extends CenarioComBiblioteca {
	private TipoBiblioteca b;
	private TipoId idLivro;
	private TipoDevolucao devolucao;

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
		nãoHáMulta();
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
		devolucao = b.devolver(idLivro);
	}

	@Test
	public void oExemplarFicaráDisponível() {
		assertEquals(DISPONÍVEL, b.obterEstadoLivro(idLivro));
	}

	@Test
	public void nãoHáMulta() {
		assertFalse(devolucao.possuiMulta());
		assertEquals(new Multa(new CentavosDeReal(0)),devolucao.obterMulta());
	}

	@Test
	public void oPrazoDeDevolucaoÉZero() {
		assertEquals(0, b.obterPrazoDevolucao(idLivro)
				.obterPrazoDevolucaoRelativoAHoje());
	}
}

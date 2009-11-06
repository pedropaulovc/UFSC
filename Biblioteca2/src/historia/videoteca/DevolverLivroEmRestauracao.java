package historia.videoteca;

import static org.junit.Assert.assertEquals;
import static producao.livro.EstadoEmprestimo.EM_RESTAURAÇÃO;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.TipoBiblioteca;
import producao.dados.id.TipoId;

public class DevolverLivroEmRestauracao extends CenarioComBiblioteca {
	private TipoBiblioteca b;
	private TipoId idLivro;

	public void dadoQue() {
		existeUmaBiblioteca();
		aBibliotecaPossuiUmLivro();
		oExemplarEstáEmRestauração();
	}

	public void quando() {
		devolverOExemplarNoPrazo();
	}

	public void então() {
		oExemplarContinuaEmRestauração();
		oPrazoDeDevolucaoÉZero();
	}

	private void existeUmaBiblioteca() {
		b = obterBiblioteca();
	}

	private void aBibliotecaPossuiUmLivro() {
		idLivro = b.adicionarLivro(obterLivro());
	}

	private void oExemplarEstáEmRestauração() {
		b.alterarEstado(idLivro, EM_RESTAURAÇÃO);
	}

	private void devolverOExemplarNoPrazo() {
		b.devolver(idLivro);
	}

	@Test
	public void oExemplarContinuaEmRestauração() {
		assertEquals(EM_RESTAURAÇÃO, b.obterEstadoDocumento(idLivro));
	}

	@Test
	public void oPrazoDeDevolucaoÉZero() {
		assertEquals(0, b.obterPrazoDevolucao(idLivro)
				.obterPrazoDevolucaoRelativoAHoje());
	}
}

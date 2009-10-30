package historia;

import static org.junit.Assert.assertEquals;
import static producao.livro.EstadoEmprestimo.CONSULTA_LOCAL;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.TipoBiblioteca;
import producao.livro.id.TipoIdLivro;

public class DevolverExemplarConsultaLocal extends CenarioComBiblioteca {
	private TipoBiblioteca b;
	private TipoIdLivro idLivro;

	public void dadoQue() {
		existeUmaBiblioteca();
		aBibliotecaPossuiUmLivro();
		oExemplarEstáEmConsultaLocal();
	}

	public void quando() {
		devolverOExemplar();
	}

	public void então() {
		oExemplarContinuaEmConsultaLocal();
		oPrazoDeDevolucaoÉZero();
	}

	private void existeUmaBiblioteca() {
		b = obterBiblioteca();
	}

	private void aBibliotecaPossuiUmLivro() {
		idLivro = b.adicionar(obterLivro());
	}

	private void oExemplarEstáEmConsultaLocal() {
		b.alterarEstado(idLivro, CONSULTA_LOCAL);
	}

	private void devolverOExemplar() {
		b.devolver(idLivro);
	}

	@Test
	public void oExemplarContinuaEmConsultaLocal() {
		assertEquals(CONSULTA_LOCAL, b.obterEstadoLivro(idLivro));
	}

	@Test
	public void oPrazoDeDevolucaoÉZero() {
		assertEquals(0, b.obterPrazoDevolucao(idLivro)
				.obterPrazoDevolucaoRelativoAHoje());
	}
}

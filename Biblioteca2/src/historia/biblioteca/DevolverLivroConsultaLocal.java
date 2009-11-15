package historia.biblioteca;

import static org.junit.Assert.assertEquals;
import static producao.documento.arquivavel.EstadoEmprestimo.CONSULTA_LOCAL;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.modelo.TipoBiblioteca;
import producao.dados.id.TipoId;

public class DevolverLivroConsultaLocal extends CenarioComBiblioteca {
	private TipoBiblioteca b;
	private TipoId idLivro;

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
		assertEquals(CONSULTA_LOCAL, b.obterEstadoDocumento(idLivro));
	}

	@Test
	public void oPrazoDeDevolucaoÉZero() {
		assertEquals(0, b.obterPrazoDevolucao(idLivro)
				.obterPrazoDevolucaoRelativoAHoje());
	}
}

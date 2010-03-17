package historia.biblioteca;

import static org.junit.Assert.assertEquals;
import static producao.documento.arquivavel.EstadoEmprestimo.CONSULTA_LOCAL;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.modelo.Biblioteca;
import producao.dados.id.TipoId;

public class TornarLivroConsultaLocal extends CenarioComBiblioteca {
	private Biblioteca b;
	private TipoId idLivro;

	public void dadoQue() {
		existeUmaBiblioteca();
		aBibliotecaPossuiUmLivro();
	}

	public void quando() {
		tornarOExemplarConsultaLocal();
	}

	public void então() {
		oExemplarTornaSeConsultaLocal();
	}

	private void existeUmaBiblioteca() {
		b = obterBiblioteca();
	}

	private void aBibliotecaPossuiUmLivro() {
		idLivro = b.adicionar(obterLivro());
	}

	private void tornarOExemplarConsultaLocal() {
		b.alterarEstado(idLivro, CONSULTA_LOCAL);
	}

	@Test
	public void oExemplarTornaSeConsultaLocal() {
		assertEquals(CONSULTA_LOCAL, b.obterEstadoDocumento(idLivro));
	}
}

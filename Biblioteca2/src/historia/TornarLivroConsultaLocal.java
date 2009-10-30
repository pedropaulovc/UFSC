package historia;

import static org.junit.Assert.assertEquals;
import static producao.livro.EstadoEmprestimo.CONSULTA_LOCAL;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.TipoBiblioteca;
import producao.livro.id.TipoIdLivro;

public class TornarLivroConsultaLocal extends CenarioComBiblioteca {
	private TipoBiblioteca b;
	private TipoIdLivro idLivro;

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
		assertEquals(CONSULTA_LOCAL, b.obterEstadoLivro(idLivro));
	}
}

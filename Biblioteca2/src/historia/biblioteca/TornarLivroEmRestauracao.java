package historia.biblioteca;

import static org.junit.Assert.assertEquals;
import static producao.documento.arquivavel.EstadoEmprestimo.EM_RESTAURAÇÃO;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.modelo.TipoBiblioteca;
import producao.dados.id.TipoId;

public class TornarLivroEmRestauracao extends CenarioComBiblioteca {
	private TipoBiblioteca b;
	private TipoId idLivro;

	public void dadoQue() {
		existeUmaBiblioteca();
		aBibliotecaPossuiUmLivro();
	}

	public void quando() {
		tornarOLivroConsultaLocal();
	}

	public void então() {
		oLivroSeTornaConsultaLocal();
	}

	private void existeUmaBiblioteca() {
		b = obterBiblioteca();
	}

	private void aBibliotecaPossuiUmLivro() {
		idLivro = b.adicionar(obterLivro());
	}

	private void tornarOLivroConsultaLocal() {
		b.alterarEstado(idLivro, EM_RESTAURAÇÃO);
	}

	@Test
	public void oLivroSeTornaConsultaLocal() {
		assertEquals(EM_RESTAURAÇÃO, b.obterEstadoDocumento(idLivro));
	}
}

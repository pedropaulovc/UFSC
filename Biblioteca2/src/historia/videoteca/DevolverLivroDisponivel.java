package historia.videoteca;

import static org.junit.Assert.assertEquals;
import static producao.livro.EstadoEmprestimo.DISPONÍVEL;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.TipoBiblioteca;
import producao.dados.id.TipoId;

public class DevolverLivroDisponivel extends CenarioComBiblioteca {
	private TipoBiblioteca b;
	private TipoId idLivro;

	public void dadoQue() {
		existeUmaBiblioteca();
		aBibliotecaPossuiUmLivro();
	}

	public void quando() {
		devolverOExemplarNoPrazo();
	}

	public void então() {
		oExemplarContinuaDisponível();
		oPrazoDeDevolucaoÉZero();
	}

	private void existeUmaBiblioteca() {
		b = obterBiblioteca();
	}

	private void aBibliotecaPossuiUmLivro() {
		idLivro = b.adicionarLivro(obterLivro());
	}

	private void devolverOExemplarNoPrazo() {
		b.devolver(idLivro);
	}

	@Test
	public void oExemplarContinuaDisponível() {
		assertEquals(DISPONÍVEL, b.obterEstadoDocumento(idLivro));
	}

	@Test
	public void oPrazoDeDevolucaoÉZero() {
		assertEquals(0, b.obterPrazoDevolucao(idLivro)
				.obterPrazoDevolucaoRelativoAHoje());
	}
}

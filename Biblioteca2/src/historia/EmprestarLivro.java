package historia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static producao.livro.EstadoEmprestimo.EMPRESTADO;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.TipoBiblioteca;
import producao.dados.id.TipoId;
import producao.dados.prazoDevolucao.PrazoDevolucao;

public class EmprestarLivro extends CenarioComBiblioteca {
	private TipoBiblioteca b;
	private TipoId idLivro;

	public void dadoQue() {
		existeUmaBiblioteca();
		aBibliotecaPossuiUmLivroDisponivel();
	}

	public void quando() {
		emprestarOExemplar();
	}

	public void então() {
		oExemplarFicaráEmprestado();
		oPrazoDeDevolucaoÉDe15Dias();
	}

	private void existeUmaBiblioteca() {
		b = obterBiblioteca();
	}

	private void aBibliotecaPossuiUmLivroDisponivel() {
		idLivro = b.adicionar(obterLivro());
	}

	private void emprestarOExemplar() {
		b.emprestar(idLivro);
	}

	@Test
	public void oExemplarFicaráEmprestado() {
		assertTrue(EMPRESTADO.equals(b.obterEstadoLivro(idLivro)));
	}

	@Test
	public void oPrazoDeDevolucaoÉDe15Dias() {		
		assertEquals(new PrazoDevolucao(15), b.obterPrazoDevolucao(idLivro));
	}
}

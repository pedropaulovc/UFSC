package historia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static producao.livro.EstadoEmprestimo.EMPRESTADO;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.TipoBiblioteca;
import producao.livro.exemplar.prazoDevolucao.PrazoDevolucao;
import producao.livro.id.TipoIdLivro;

public class EmprestarExemplar extends CenarioComBiblioteca {
	private TipoBiblioteca b;
	private TipoIdLivro idLivro;

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

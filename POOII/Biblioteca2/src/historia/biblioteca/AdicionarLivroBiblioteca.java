package historia.biblioteca;

import static org.junit.Assert.assertEquals;
import static producao.documento.arquivavel.EstadoEmprestimo.DISPONÍVEL;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.modelo.Biblioteca;
import producao.dados.id.TipoId;
import producao.livro.Livro;

public class AdicionarLivroBiblioteca extends CenarioComBiblioteca {
	private Biblioteca b;
	private TipoId idLivro;
	private Livro livro;

	public void dadoQue() {
		existeUmaBibliotecaComNenhumLivro();
		existemDadosDeUmLivroArquivavel();
	}

	public void quando() {
		adicionaLivroNaBiblioteca();
	}

	public void então() {
		aBibliotecaPossuiUmLivro();
		éPossívelObterOLivroArmazenado();
		oLivroFicaDisponível();
	}

	@Test
	public void existeUmaBibliotecaComNenhumLivro() {
		b = obterBiblioteca();

		assertEquals(0, b.tamanho());
	}

	private void existemDadosDeUmLivroArquivavel() {
		livro = obterLivro();
	}

	private void adicionaLivroNaBiblioteca() {
		idLivro = b.adicionar(livro);
	}

	@Test
	public void aBibliotecaPossuiUmLivro() {
		assertEquals(1, b.tamanho());
	}

	@Test
	public void éPossívelObterOLivroArmazenado() {
		assertEquals(livro, b.obter(idLivro));
	}

	@Test
	public void oLivroFicaDisponível() {
		assertEquals(DISPONÍVEL, b.obterEstadoDocumento(idLivro));
	}
}

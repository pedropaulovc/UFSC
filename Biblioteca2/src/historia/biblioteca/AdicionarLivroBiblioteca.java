package historia.biblioteca;

import static org.junit.Assert.assertEquals;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.modelo.TipoBiblioteca;
import producao.dados.id.TipoId;
import static producao.documento.arquivavel.EstadoEmprestimo.*;
import producao.livro.TipoLivro;

public class AdicionarLivroBiblioteca extends CenarioComBiblioteca {
	private TipoBiblioteca b;
	private TipoId idLivro;
	private TipoLivro livro;

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

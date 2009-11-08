package historia.biblioteca;

import static org.junit.Assert.assertEquals;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.modelo.TipoBiblioteca;
import producao.dados.id.TipoId;
import producao.dados.numeroChamada.modelo.NumeroChamada;
import static producao.documento.arquivavel.EstadoEmprestimo.*;
import producao.livro.TipoLivro;
import producao.livro.arquivavel.dados.DadosLivroArquivavel;
import producao.livro.arquivavel.dados.TipoDadosLivroArquivavel;

public class AdicionarLivroComDadosArquivoBiblioteca extends
		CenarioComBiblioteca {
	private TipoBiblioteca b;
	private TipoId idLivro;
	private TipoLivro livro;
	private TipoDadosLivroArquivavel dadosArquivo;

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
		oLivroPossuiOsDadosDeArquivoFornecidos();
		oLivroFicaDisponível();
	}

	@Test
	public void existeUmaBibliotecaComNenhumLivro() {
		b = obterBiblioteca();

		assertEquals(0, b.tamanho());
	}

	private void existemDadosDeUmLivroArquivavel() {
		livro = obterLivro();
		dadosArquivo = new DadosLivroArquivavel(new NumeroChamada("123.223"));
	}

	private void adicionaLivroNaBiblioteca() {
		idLivro = b.adicionarLivro(livro, dadosArquivo);
	}

	@Test
	public void aBibliotecaPossuiUmLivro() {
		assertEquals(1, b.tamanho());
	}

	@Test
	public void éPossívelObterOLivroArmazenado() {
		assertEquals(livro, b.obterLivro(idLivro));
	}

	@Test
	public void oLivroPossuiOsDadosDeArquivoFornecidos() {
		assertEquals(dadosArquivo, b.obterDadosDeArquivo(idLivro));
	}

	@Test
	public void oLivroFicaDisponível() {
		assertEquals(DISPONÍVEL, b.obterEstadoDocumento(idLivro));
	}
}

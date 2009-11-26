package historia.biblioteca;

import static org.junit.Assert.assertEquals;
import static producao.documento.arquivavel.EstadoEmprestimo.DISPONÍVEL;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.modelo.Biblioteca;
import producao.dados.id.TipoId;
import producao.dados.numeroChamada.modelo.NumeroChamada;
import producao.livro.Livro;
import producao.livro.arquivavel.dados.DadosLivroArquivavel;

public class AdicionarLivroComDadosArquivoBiblioteca extends
		CenarioComBiblioteca {
	private Biblioteca b;
	private TipoId idLivro;
	private Livro livro;
	private DadosLivroArquivavel dadosArquivo;

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
		idLivro = b.adicionar(livro, dadosArquivo);
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
	public void oLivroPossuiOsDadosDeArquivoFornecidos() {
		assertEquals(dadosArquivo, b.obterDadosDeArquivo(idLivro));
	}

	@Test
	public void oLivroFicaDisponível() {
		assertEquals(DISPONÍVEL, b.obterEstadoDocumento(idLivro));
	}
}

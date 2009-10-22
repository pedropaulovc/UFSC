package historia;

import static org.junit.Assert.*;
import infra.Cenario;

import org.junit.Test;

import producao.livro.DadosArquivoLivro;
import producao.livro.DadosLivro;
import producao.livro.Editora;
import producao.livro.TipoLivroArquivavel;

public class TornarLivroArquivavel extends Cenario {
	private TipoLivroArquivavel l;
	private Editora e;
	private DadosLivro dl;
	private DadosArquivoLivro dal;

	public void dadoQue() {
		existeUmaEditora();
		existemDadosValidosDoLivro();
		existemDadosValidosDeArquivoDoLivro();
	}

	public void quando() {
		criarUmLivroComOsDados();
	}

	public void então() {
		receboUmNovoLivroComOsMesmosDados();
	}

	private void existeUmaEditora() {
		e = new Editora();
	}

	private void existemDadosValidosDoLivro() {
		dl = new DadosLivro(
				"Nome do Título;Nome do Autor");
	}

	private void existemDadosValidosDeArquivoDoLivro() {
		dal = new DadosArquivoLivro("123.22");
	}

	private void criarUmLivroComOsDados() {
		l = e.criarLivro(dl, dal);
	}

	@Test
	public void receboUmNovoLivroComOsMesmosDados() {
		assertEquals(dl.obterTitulo(), l.obterTitulo());
		assertEquals(dl.obterAutor(), l.obterAutor());
		assertEquals(dal.obterNumeroChamada(), l.obterNumeroChamada());
	}
}

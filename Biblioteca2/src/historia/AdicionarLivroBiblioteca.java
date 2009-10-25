package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.Biblioteca;
import producao.ConfiguracaoBiblioteca;
import producao.TipoBiblioteca;
import producao.livro.DadosLivro;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoIdentificacao;

public class AdicionarLivroBiblioteca extends Cenario {
	private TipoBiblioteca b;
	private TipoDadosLivro dados;
	private TipoIdentificacao idLivro;

	public void dadoQue() {
		existeUmaBibliotecaComNenhumLivro();
		existemDadosDeUmLivroArquivavel();
	}

	public void quando() {
		adicionaLivroNaBiblioteca();
	}

	public void então() {
		aBibliotecaPossuiUmLivro();
		éPossívelObterOsDadosDoLivroArmazenado();
	}

	@Test
	public void existeUmaBibliotecaComNenhumLivro() {
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central"));

		assertEquals(0, b.tamanho());
	}

	private void existemDadosDeUmLivroArquivavel() {
		dados = new DadosLivro("Nome do Título;Nome do Autor");
	}

	private void adicionaLivroNaBiblioteca() {
		idLivro = b.adicionar(dados);
	}

	@Test
	public void aBibliotecaPossuiUmLivro() {
		assertEquals(1, b.tamanho());
	}

	@Test
	public void éPossívelObterOsDadosDoLivroArmazenado() {
		assertEquals(dados, b.obterDadosLivro(idLivro));
	}
}

package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.Biblioteca;
import producao.ConfiguracaoBiblioteca;
import producao.TipoBiblioteca;
import producao.TipoConfiguracaoBiblioteca;
import producao.livro.DadosExemplar;
import producao.livro.DadosLivro;
import producao.livro.EditoraBiblioteca;
import producao.livro.TipoDadosExemplar;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEditoraBiblioteca;
import producao.livro.TipoLivroComExemplaresArquivaveis;

public class AdicionarLivroArquivavelBiblioteca extends Cenario {
	private TipoBiblioteca b;
	private TipoLivroComExemplaresArquivaveis livro;

	public void dadoQue() {
		existeUmaBibliotecaComNenhumLivro();
		existeUmLivroArquivavel();
	}

	public void quando() {
		adicionaLivroNaBiblioteca();
	}

	public void então() {
		aBibliotecaPossuiUmLivro();
		éPossívelObterOLivroArmazenado();
	}

	@Test
	public void existeUmaBibliotecaComNenhumLivro() {
		TipoConfiguracaoBiblioteca configuração = new ConfiguracaoBiblioteca(
				"Biblioteca Central");
		b = new Biblioteca(configuração);

		assertEquals(0, b.tamanho());
	}

	private void existeUmLivroArquivavel() {
		TipoEditoraBiblioteca editora = new EditoraBiblioteca();

		TipoDadosLivro dados = new DadosLivro("Nome do Título;Nome do Autor");
		livro = editora.criarLivroComExemplaresArquivaveis(dados);

		TipoDadosExemplar dadosExemplar = new DadosExemplar("3a edicao;1999");
		livro.adicionarExemplar(dadosExemplar);
	}

	private void adicionaLivroNaBiblioteca() {
		b.adicionar(livro);
	}

	@Test
	public void aBibliotecaPossuiUmLivro() {
		assertEquals(1, b.tamanho());
	}

	@Test
	public void éPossívelObterOLivroArmazenado() {
		assertEquals(livro, b.obterLivro(1));
	}
}

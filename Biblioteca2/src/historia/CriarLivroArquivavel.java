package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.livro.DadosLivro;
import producao.livro.EditoraBiblioteca;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEditoraBiblioteca;
import producao.livro.TipoLivroComExemplaresArquivaveis;

public class CriarLivroArquivavel extends Cenario {
	private TipoLivroComExemplaresArquivaveis livro;
	private TipoEditoraBiblioteca editora;
	private TipoDadosLivro dados;

	public void dadoQue() {
		existeUmaEditoraDeBiblioteca();
		haDadosValidosDeUmLivro();
	}

	public void quando() {
		criarUmNovoLivroArquivavelComOsDados();
	}

	public void então() {
		receboUmNovoLivroArquivavelComOsMesmosDados();
	}

	private void existeUmaEditoraDeBiblioteca() {
		editora = new EditoraBiblioteca();
	}

	private void haDadosValidosDeUmLivro() {
		dados = new DadosLivro("Nome do Título;Nome do Autor");
	}
	
	private void criarUmNovoLivroArquivavelComOsDados() {
		livro = editora.criarLivroComExemplaresArquivaveis(dados);
	}

	@Test
	public void receboUmNovoLivroArquivavelComOsMesmosDados() {
		assertEquals(dados.obterTitulo(), livro.obterTitulo());
		assertEquals(dados.obterAutor(), livro.obterAutor());
	}
}

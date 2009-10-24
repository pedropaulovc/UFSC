package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.livro.DadosLivro;
import producao.livro.EditoraBiblioteca;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEditoraBiblioteca;
import producao.livro.TipoLivro;
import producao.livro.TipoLivroArquivavel;

public class CriarLivro extends Cenario {
	private TipoLivroArquivavel livro;
	private TipoEditoraBiblioteca editora;
	private TipoDadosLivro dados;

	public void dadoQue() {
		existeUmaEditora();
		haDadosValidosDeUmLivro();
	}

	public void quando() {
		criarUmNovoLivroComOsDados();
	}

	public void então() {
		receboUmNovoLivroComOsMesmosDados();
	}

	private void existeUmaEditora() {
		editora = new EditoraBiblioteca();
	}

	private void haDadosValidosDeUmLivro() {
		dados = new DadosLivro("Nome do Título;Nome do Autor");
	}
	
	private void criarUmNovoLivroComOsDados() {
		livro = editora.criarLivro(dados);
	}

	@Test
	public void receboUmNovoLivroComOsMesmosDados() {
		assertEquals(dados.obterTitulo(), livro.obterTitulo());
		assertEquals(dados.obterAutor(), livro.obterAutor());
	}
}

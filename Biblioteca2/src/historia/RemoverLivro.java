package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.Biblioteca;
import producao.ConfiguracaoBiblioteca;
import producao.TipoBiblioteca;
import producao.TipoConfiguracaoBiblioteca;
import producao.livro.DadosLivro;
import producao.livro.EditoraBiblioteca;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEditoraBiblioteca;
import producao.livro.TipoLivroComExemplaresArquivaveis;

public class RemoverLivro extends Cenario {
	private TipoBiblioteca b;
	private TipoLivroComExemplaresArquivaveis livro;

	public void dadoQue() {
		existeUmaBibliotecaComUmLivro();
	}

	public void quando() {
		removeOLivro();
	}

	public void então() {
		bibliotecaFicaComNenhumLivro();
	}

	private void existeUmaBibliotecaComUmLivro() {
		TipoConfiguracaoBiblioteca configuração = new ConfiguracaoBiblioteca(
				"Biblioteca Central");
		b = new Biblioteca(configuração);
		
		TipoEditoraBiblioteca editora = new EditoraBiblioteca();
		TipoDadosLivro dados = new DadosLivro("Nome do Título;Nome do Autor");
		livro = editora.criarLivroComExemplaresArquivaveis(dados);
		
		b.adicionar(livro);
		
		assertEquals(1, b.tamanho());
	}

	private void removeOLivro() {
		b.removerLivro(1);
	}

	@Test
	public void bibliotecaFicaComNenhumLivro() {
		assertEquals(0, b.tamanho());
	}
}

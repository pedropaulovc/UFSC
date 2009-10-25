package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.livro.DadosExemplarArquivavel;
import producao.livro.DadosLivro;
import producao.livro.EditoraBiblioteca;
import producao.livro.TipoDadosExemplarArquivavel;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEditoraBiblioteca;
import producao.livro.TipoLivroComExemplaresArquivaveis;

public class RemoverExemplarEmLivro extends Cenario {
	private TipoLivroComExemplaresArquivaveis livro;

	public void dadoQue() {
		existeUmLivroComUmExemplar();
	}

	public void quando() {
		removerExemplar();
	}

	public void então() {
		livroPossuiNenhumExemplar();
	}

	private void existeUmLivroComUmExemplar() {
		TipoEditoraBiblioteca editora = new EditoraBiblioteca();
		TipoDadosLivro dados = new DadosLivro("Nome do Título;Nome do Autor");
		livro = editora.criarLivroComExemplaresArquivaveis(dados);

		TipoDadosExemplarArquivavel dadosExemplar = new DadosExemplarArquivavel(
				"Editora;1999;Numero Chamada");

		livro.adicionarExemplar(dadosExemplar);

		assertEquals(1, livro.qtdExemplares());
	}

	private void removerExemplar() {
		livro.removerExemplar(1);
	}

	@Test
	public void livroPossuiNenhumExemplar() {
		assertEquals(0, livro.qtdExemplares());
	}
}

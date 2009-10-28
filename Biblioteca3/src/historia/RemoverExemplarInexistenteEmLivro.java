package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.livro.dados.DadosLivro;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.editora.EditoraBiblioteca;
import producao.livro.editora.TipoEditoraBiblioteca;
import producao.livro.exemplar.TipoLivroComExemplaresArquivaveis;
import producao.livro.exemplar.dados.DadosExemplarArquivavel;
import producao.livro.exemplar.dados.TipoDadosExemplarArquivavel;
import producao.livro.exemplar.id.IdExemplar;

public class RemoverExemplarInexistenteEmLivro extends Cenario {
	private TipoLivroComExemplaresArquivaveis livro;
	private TipoDadosExemplarArquivavel dadosExemplar;

	public void dadoQue() {
		existeUmLivroComUmExemplar();
	}

	public void quando() {
		removerExemplarInexistente();
	}

	public void então() {
		livroPossuiContinuaComUmExemplar();
	}

	private void existeUmLivroComUmExemplar() {
		TipoEditoraBiblioteca editora = new EditoraBiblioteca();
		TipoDadosLivro dados = new DadosLivro("Nome do Título;Nome do Autor");
		livro = editora.criarLivroComExemplaresArquivaveis(dados);

		dadosExemplar = new DadosExemplarArquivavel(
				"Editora;1999;Numero Chamada");

		livro.adicionarExemplar(dadosExemplar);

		assertEquals(1, livro.qtdExemplares());
	}
	
	private void removerExemplarInexistente() {
		livro.removerExemplar(new IdExemplar());
	}

	@Test
	public void livroPossuiContinuaComUmExemplar() {
		assertEquals(1, livro.qtdExemplares());
	}
}

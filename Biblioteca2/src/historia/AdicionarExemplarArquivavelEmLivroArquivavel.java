package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.livro.DadosExemplar;
import producao.livro.DadosLivro;
import producao.livro.EditoraBiblioteca;
import producao.livro.TipoDadosExemplar;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEditoraBiblioteca;
import producao.livro.TipoLivroComExemplaresArquivaveis;

public class AdicionarExemplarArquivavelEmLivroArquivavel extends Cenario {
	private TipoLivroComExemplaresArquivaveis livro;
	private TipoDadosExemplar dadosExemplar;

	public void dadoQue() {
		existeUmLivroArquivavelSemExemplaresArquivaveis();
		existemDadosDeExemplar();
	}

	public void quando() {
		adicionaExemplarAoLivro();
	}

	public void então() {
		exemplarPossuiMesmosDadosFornecidos();
		livroPossuiUmExemplar();
		livroPermiteRemoverExemplar();
	}

	@Test
	public void existeUmLivroArquivavelSemExemplaresArquivaveis() {
		TipoEditoraBiblioteca editora = new EditoraBiblioteca();

		TipoDadosLivro dados = new DadosLivro("Nome do Título;Nome do Autor");
		livro = editora.criarLivroComExemplaresArquivaveis(dados);

		assertEquals(0, livro.qtdExemplares());
	}

	private void existemDadosDeExemplar() {
		dadosExemplar = new DadosExemplar("3a edicao;1999");
	}

	private void adicionaExemplarAoLivro() {
		livro.adicionarExemplar(dadosExemplar);
	}

	@Test
	public void exemplarPossuiMesmosDadosFornecidos() {		
		assertEquals(dadosExemplar.obterAnoPublicacao(), livro.obterAnoPublicacaoExemplar(1));
		assertEquals(dadosExemplar.obterEditora(), livro.obterNomeEditoraExemplar(1));
	}

	@Test
	public void livroPossuiUmExemplar() {
		assertEquals(1,livro.qtdExemplares());
	}

	@Test
	public void livroPermiteRemoverExemplar() {
		livro.removerExemplar(1);
		assertEquals(0, livro.qtdExemplares());
	}
}

package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.livro.dados.DadosLivro;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.editora.Editora;
import producao.livro.editora.TipoEditora;
import producao.livro.exemplar.TipoLivroComExemplaresNaoArquivaveis;
import producao.livro.exemplar.dados.DadosExemplar;
import producao.livro.exemplar.dados.TipoDadosExemplar;
import producao.livro.exemplar.id.TipoIdExemplar;

public class AdicionarMaisExemplaresEmLivro extends Cenario {
	private TipoLivroComExemplaresNaoArquivaveis livro;
	private TipoDadosExemplar dadosExemplar2;
	private TipoIdExemplar idExemplar;

	public void dadoQue() {
		existeUmLivroComUmExemplar();
		existemDadosDeOutroExemplar();
	}

	public void quando() {
		adicionaExemplarAoLivro();
	}

	public void então() {
		exemplarPossuiMesmosDadosFornecidos();
		livroPossuiDoisExemplares();
		livroPermiteRemoverExemplar();
	}

	@Test
	public void existeUmLivroComUmExemplar() {
		TipoEditora editora = new Editora();

		TipoDadosLivro dados = new DadosLivro("Nome do Título;Nome do Autor");
		livro = editora.criarLivroComExemplares(dados);

		DadosExemplar dadosExemplar1 = new DadosExemplar("3a edicao;1999");
		livro.adicionarExemplar(dadosExemplar1);
		
		assertEquals(1, livro.qtdExemplares());
	}

	private void existemDadosDeOutroExemplar() {
		dadosExemplar2 = new DadosExemplar("4a edicao;1999");
	}

	private void adicionaExemplarAoLivro() {
		idExemplar = livro.adicionarExemplar(dadosExemplar2);
	}

	@Test
	public void exemplarPossuiMesmosDadosFornecidos() {
		assertEquals(dadosExemplar2, livro.obterDadosExemplar(idExemplar));
	}

	@Test
	public void livroPossuiDoisExemplares() {
		assertEquals(2, livro.qtdExemplares());
	}

	@Test
	public void livroPermiteRemoverExemplar() {
		livro.removerExemplar(idExemplar);
		assertEquals(1, livro.qtdExemplares());
	}
}

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

public class AdicionarExemplarEmLivro extends Cenario {
	private TipoLivroComExemplaresNaoArquivaveis livro;
	private TipoDadosExemplar dadosExemplar;
	private TipoIdExemplar idExemplar;

	public void dadoQue() {
		existeUmLivroSemExemplares();
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
	public void existeUmLivroSemExemplares() {
		TipoEditora editora = new Editora();

		TipoDadosLivro dados = new DadosLivro("Nome do Título;Nome do Autor");
		livro = editora.criarLivroComExemplares(dados);

		assertEquals(0, livro.qtdExemplares());
	}

	private void existemDadosDeExemplar() {
		dadosExemplar = new DadosExemplar("3a edicao;1999");
	}

	private void adicionaExemplarAoLivro() {
		idExemplar = livro.adicionarExemplar(dadosExemplar);
	}

	@Test
	public void exemplarPossuiMesmosDadosFornecidos() {
		assertEquals(dadosExemplar, livro.obterDadosExemplar(idExemplar));
	}

	@Test
	public void livroPossuiUmExemplar() {
		assertEquals(1, livro.qtdExemplares());
	}

	@Test
	public void livroPermiteRemoverExemplar() {
		livro.removerExemplar(idExemplar);
		assertEquals(0, livro.qtdExemplares());
	}
}

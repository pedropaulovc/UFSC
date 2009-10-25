package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.livro.DadosExemplar;
import producao.livro.DadosLivro;
import producao.livro.Editora;
import producao.livro.TipoDadosExemplar;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEditora;
import producao.livro.TipoLivroComExemplaresNaoArquivaveis;

public class AdicionarExemplarEmLivro extends Cenario {
	private TipoLivroComExemplaresNaoArquivaveis livro;
	private TipoDadosExemplar dadosExemplar;

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
		livro.adicionarExemplar(dadosExemplar);
	}

	@Test
	public void exemplarPossuiMesmosDadosFornecidos() {
		assertEquals(dadosExemplar, livro.obterDadosExemplar(dadosExemplar
				.obterIdentificacao()));
	}

	@Test
	public void livroPossuiUmExemplar() {
		assertEquals(1, livro.qtdExemplares());
	}

	@Test
	public void livroPermiteRemoverExemplar() {
		livro.removerExemplar(dadosExemplar.obterIdentificacao());
		assertEquals(0, livro.qtdExemplares());
	}
}

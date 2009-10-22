package historia;

import static org.junit.Assert.*;

import org.junit.Test;

import producao.livro.DadosEdicao;
import producao.livro.DadosLivro;
import producao.livro.Edicao;
import producao.livro.Editora;
import producao.livro.TipoDadosEdicao;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEdicao;
import producao.livro.TipoEditora;
import producao.livro.TipoLivro;

import infra.Cenario;

public class AdicionarEdicoesDiferentesEmLivro extends Cenario {
	private TipoLivro livro;
	private TipoEdicao edicao;
	private TipoDadosEdicao dadosEdicao;

	public void dadoQue() {
		existeUmLivroSemEdicoes();
		existeUmaEdicao();
	}

	public void quando() {
		adicionaEdicaoAUmLivro();
	}

	public void então() {
		edicaoPossuiMesmosDadosFornecidos();
		livroPossuiUmaEdicao();
		livroPermiteObterEdicao();
		livroPermiteRemoverEdicao();
	}

	private void existeUmLivroSemEdicoes() {
		TipoEditora editora = new Editora();
		TipoDadosLivro dados = new DadosLivro(
				"Nome do Título;Nome do Autor");
		livro = editora.criarLivro(dados);
	}

	private void existeUmaEdicao() {
		dadosEdicao = new DadosEdicao("3a edicao;1999");
		edicao = new Edicao(dadosEdicao);
	}

	private void adicionaEdicaoAUmLivro() {
		livro.adicionarEdicao(edicao);
	}

	@Test
	public void edicaoPossuiMesmosDadosFornecidos() {
		assertEquals(dadosEdicao.obterAnoPublicacao(), edicao.obterAnoPublicacao());
		assertEquals(dadosEdicao.obterEditora(), edicao.obterEditora());
	}
	
	@Test
	public void livroPossuiUmaEdicao() {
		assertEquals(1, livro.qtdEdicoes());
	}
	
	@Test
	public void livroPermiteObterEdicao() {
		assertEquals(edicao, livro.obterEdicao(1));		
	}
	
	@Test
	public void livroPermiteRemoverEdicao() {
		assertEquals(edicao, livro.removerEdicao(1));
	}
}

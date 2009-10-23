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
import producao.livro.TipoLivro;

public class RemoverExemplarEmLivro extends Cenario {
	private TipoLivro livro;

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
		TipoEditora editora = new Editora();
		TipoDadosLivro dados = new DadosLivro("Nome do Título;Nome do Autor");
		livro = editora.criarLivro(dados);
		
		TipoDadosExemplar dadosExemplar = new DadosExemplar("Editora;1999");
		
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

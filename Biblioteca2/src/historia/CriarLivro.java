package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.livro.TipoLivro;
import producao.livro.dados.DadosLivro;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.editora.Editora;
import producao.livro.editora.TipoEditora;

public class CriarLivro extends Cenario {
	private TipoLivro livro;
	private TipoEditora editora;
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
		editora = new Editora();
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

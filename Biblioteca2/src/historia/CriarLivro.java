package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.livro.DadosLivro;
import producao.livro.Editora;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEditora;
import producao.livro.TipoLivro;

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
		dados = new DadosLivro("Nome do Título;Nome do Autor;Nome da Editora;1999");
	}
	
	private void criarUmNovoLivroComOsDados() {
		livro = editora.criarLivro(dados);
	}

	@Test
	public void receboUmNovoLivroComOsMesmosDados() {
		assertEquals(dados.obterTitulo(), livro.obterTitulo());
		assertEquals(dados.obterAutor(), livro.obterAutor());
		assertEquals(dados.obterEditora(), livro.obterEditora());
		assertEquals(dados.obterAnoPublicacao(), livro.obterAnoPublicacao());
	}
}

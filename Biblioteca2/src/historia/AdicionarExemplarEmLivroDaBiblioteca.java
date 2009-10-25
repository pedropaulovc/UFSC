package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.Biblioteca;
import producao.ConfiguracaoBiblioteca;
import producao.TipoBiblioteca;
import producao.livro.DadosExemplarArquivavel;
import producao.livro.DadosLivro;
import producao.livro.TipoDadosExemplarArquivavel;

public class AdicionarExemplarEmLivroDaBiblioteca extends Cenario {
	private TipoDadosExemplarArquivavel dadosExemplar;
	private TipoBiblioteca b;

	public void dadoQue() {
		existeUmaBiblioteca();
		aBibliotecaPossuiUmLivroSemExemplares();
	}

	public void quando() {
		adicionaExemplarAoLivro();
	}

	public void então() {
		exemplarPossuiMesmosDadosFornecidos();
		livroPossuiUmExemplar();
		livroPermiteRemoverExemplar();
	}

	private void existeUmaBiblioteca() {
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central"));
	}

	public void aBibliotecaPossuiUmLivroSemExemplares() {
		b.adicionar(new DadosLivro("Nome do Título;Nome do Autor"));
	}

	private void adicionaExemplarAoLivro() {
		dadosExemplar = new DadosExemplarArquivavel(
				"Editora;1999;Numero Chamada");
		b.adicionarExemplar(1, dadosExemplar);
	}

	@Test
	public void exemplarPossuiMesmosDadosFornecidos() {
		assertEquals(dadosExemplar, b.obterDadosExemplar(1, 1));
	}

	@Test
	public void livroPossuiUmExemplar() {
		assertEquals(1, b.qtdExemplares(1));
	}

	@Test
	public void livroPermiteRemoverExemplar() {
		b.removerExemplar(1, 1);
		assertEquals(0, b.qtdExemplares(1));
	}
}

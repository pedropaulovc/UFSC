package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.biblioteca.Biblioteca;
import producao.biblioteca.TipoBiblioteca;
import producao.biblioteca.configuracao.ConfiguracaoBiblioteca;
import producao.livro.dados.DadosLivro;
import producao.livro.exemplar.dados.DadosExemplarArquivavel;
import producao.livro.exemplar.dados.TipoDadosExemplarArquivavel;
import producao.livro.exemplar.id.TipoIdExemplar;
import producao.livro.id.TipoIdLivro;

public class AdicionarMaisExemplaresEmLivroDaBiblioteca extends Cenario {
	private TipoDadosExemplarArquivavel dadosExemplar2;
	private TipoBiblioteca b;
	private TipoIdLivro idLivro;
	private TipoIdExemplar idExemplar2;

	public void dadoQue() {
		existeUmaBiblioteca();
		aBibliotecaPossuiUmLivroComUmExemplar();
	}

	public void quando() {
		adicionaOutroExemplarAoLivro();
	}

	public void então() {
		exemplarPossuiMesmosDadosFornecidos();
		livroPossuiDoisExemplar();
		livroPermiteRemoverExemplar();
	}

	private void existeUmaBiblioteca() {
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central;15"));
	}

	public void aBibliotecaPossuiUmLivroComUmExemplar() {
		idLivro = b.adicionar(new DadosLivro("Nome do Título;Nome do Autor"));
		DadosExemplarArquivavel dadosExemplar1 = new DadosExemplarArquivavel(
				"Editora;1999;Numero Chamada");

		b.adicionarExemplar(idLivro, dadosExemplar1);
	}

	private void adicionaOutroExemplarAoLivro() {
		dadosExemplar2 = new DadosExemplarArquivavel(
				"Editora 2;1999;Numero Chamada");
		idExemplar2 = b.adicionarExemplar(idLivro, dadosExemplar2);
	}

	@Test
	public void exemplarPossuiMesmosDadosFornecidos() {
		assertEquals(dadosExemplar2, b.obterDadosExemplar(idExemplar2));
	}

	@Test
	public void livroPossuiDoisExemplar() {
		assertEquals(2, b.qtdExemplares(idLivro));
	}

	@Test
	public void livroPermiteRemoverExemplar() {
		b.removerExemplar(idExemplar2);
		assertEquals(1, b.qtdExemplares(idLivro));
	}

}

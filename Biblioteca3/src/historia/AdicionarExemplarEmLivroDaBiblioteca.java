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

public class AdicionarExemplarEmLivroDaBiblioteca extends Cenario {
	private TipoDadosExemplarArquivavel dadosExemplar;
	private TipoBiblioteca b;
	private TipoIdLivro idLivro;
	private TipoIdExemplar idExemplar;

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
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central;15"));
	}

	public void aBibliotecaPossuiUmLivroSemExemplares() {
		idLivro = b.adicionar(new DadosLivro("Nome do Título;Nome do Autor"));
	}

	private void adicionaExemplarAoLivro() {
		dadosExemplar = new DadosExemplarArquivavel("Editora;1999;Numero Chamada");
		idExemplar = b.adicionarExemplar(idLivro, dadosExemplar);
	}

	@Test
	public void exemplarPossuiMesmosDadosFornecidos() {
		assertEquals(dadosExemplar, b.obterDadosExemplar(idExemplar));
	}

	@Test
	public void livroPossuiUmExemplar() {
		assertEquals(1, b.qtdExemplares(idLivro));
	}

	@Test
	public void livroPermiteRemoverExemplar() {
		b.removerExemplar(idExemplar);
		assertEquals(0, b.qtdExemplares(idLivro));
	}
	
}

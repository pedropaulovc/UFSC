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
import producao.livro.TipoDadosLivro;
import producao.livro.TipoIdentificacao;

public class AdicionarExemplarEmLivroDaBiblioteca extends Cenario {
	private TipoDadosExemplarArquivavel dadosExemplar;
	private TipoBiblioteca b;
	private TipoDadosLivro dadosLivro;
	private TipoIdentificacao idLivro, idExemplar;

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
		dadosLivro = new DadosLivro("Nome do Título;Nome do Autor");
		idLivro = dadosLivro.obterIdentificacao();
		
		b.adicionar(dadosLivro);
	}

	private void adicionaExemplarAoLivro() {
		dadosExemplar = new DadosExemplarArquivavel(
				"Editora;1999;Numero Chamada");
		idExemplar = dadosExemplar.obterIdentificacao();
		b.adicionarExemplar(idLivro, dadosExemplar);
	}

	@Test
	public void exemplarPossuiMesmosDadosFornecidos() {
		assertEquals(dadosExemplar, b.obterDadosExemplar(idLivro, idExemplar));
	}

	@Test
	public void livroPossuiUmExemplar() {
		assertEquals(1, b.qtdExemplares(idLivro));
	}

	@Test
	public void livroPermiteRemoverExemplar() {
		b.removerExemplar(idLivro, idExemplar);
		assertEquals(0, b.qtdExemplares(idLivro));
	}
}

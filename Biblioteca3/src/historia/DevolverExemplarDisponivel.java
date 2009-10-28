package historia;

import static org.junit.Assert.assertEquals;
import static producao.livro.exemplar.EstadoEmprestimo.DISPONÍVEL;
import infra.Cenario;

import org.junit.Test;

import producao.biblioteca.Biblioteca;
import producao.biblioteca.TipoBiblioteca;
import producao.biblioteca.configuracao.ConfiguracaoBiblioteca;
import producao.livro.dados.DadosLivro;
import producao.livro.exemplar.dados.DadosExemplarArquivavel;
import producao.livro.exemplar.id.TipoIdExemplar;
import producao.livro.id.TipoIdLivro;

public class DevolverExemplarDisponivel extends Cenario {
	private TipoBiblioteca b;
	private TipoIdLivro idLivro;
	private TipoIdExemplar idExemplar;

	public void dadoQue() {
		existeUmaBiblioteca();
		aBibliotecaPossuiUmLivro();
		oLivroPossuiUmExemplar();
	}

	public void quando() {
		devolverOExemplarNoPrazo();
	}

	public void então() {
		oExemplarContinuaDisponível();
		oPrazoDeDevolucaoÉZero();
	}

	private void existeUmaBiblioteca() {
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central;15"));
	}

	private void aBibliotecaPossuiUmLivro() {
		idLivro = b.adicionar(new DadosLivro("Nome Livro;Autor"));
	}

	private void oLivroPossuiUmExemplar() {
		idExemplar = b.adicionarExemplar(idLivro, new DadosExemplarArquivavel(
				"Editora;1999;Numero Chamada"));
	}

	private void devolverOExemplarNoPrazo() {
		b.devolver(idExemplar);
	}

	@Test
	public void oExemplarContinuaDisponível() {
		assertEquals(DISPONÍVEL, b.obterEstadoExemplar(idExemplar));
	}

	@Test
	public void oPrazoDeDevolucaoÉZero() {
		assertEquals(0, b.obterPrazoDevolucao(idExemplar)
				.obterPrazoDevolucaoRelativoAHoje());
	}
}

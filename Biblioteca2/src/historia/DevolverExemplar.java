package historia;

import static org.junit.Assert.assertEquals;
import static producao.livro.EstadoEmprestimo.DISPONÍVEL;
import infra.Cenario;

import org.junit.Test;

import producao.Biblioteca;
import producao.ConfiguracaoBiblioteca;
import producao.TipoBiblioteca;
import producao.livro.DadosExemplarArquivavel;
import producao.livro.DadosLivro;
import producao.livro.TipoIdentificacaoExemplar;
import producao.livro.TipoIdentificacaoLivro;

public class DevolverExemplar extends Cenario {
	private TipoBiblioteca b;
	private TipoIdentificacaoLivro idLivro;
	private TipoIdentificacaoExemplar idExemplar;

	public void dadoQue() {
		existeUmaBiblioteca();
		aBibliotecaPossuiUmLivro();
		oLivroPossuiUmExemplar();
		oExemplarEstáEmprestado();
	}

	public void quando() {
		devolverOExemplarNoPrazo();
	}

	public void então() {
		oExemplarFicaráDisponível();
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

	private void oExemplarEstáEmprestado() {
		b.emprestar(idExemplar);
	}

	private void devolverOExemplarNoPrazo() {
		System.out.println("antes" + b.obterEstadoExemplar(idExemplar));
		b.devolver(idExemplar);
		System.out.println("depois" + b.obterEstadoExemplar(idExemplar));
	}

	@Test
	public void oExemplarFicaráDisponível() {
		assertEquals(DISPONÍVEL, b.obterEstadoExemplar(idExemplar));
	}

	@Test
	public void oPrazoDeDevolucaoÉZero() {
		assertEquals(0, b.obterPrazoDevolucao(idExemplar)
				.obterPrazoDevolucaoRelativoAHoje());
	}
}

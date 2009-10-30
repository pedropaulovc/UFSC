package historia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static producao.livro.exemplar.EstadoEmprestimo.EMPRESTADO;
import infra.Cenario;

import org.junit.Test;

import producao.biblioteca.Biblioteca;
import producao.biblioteca.TipoBiblioteca;
import producao.biblioteca.configuracao.ConfiguracaoBiblioteca;
import producao.livro.dados.DadosLivro;
import producao.livro.exemplar.dados.DadosExemplarArquivavel;
import producao.livro.exemplar.id.TipoIdExemplar;
import producao.livro.exemplar.prazoDevolucao.PrazoDevolucao;
import producao.livro.id.TipoIdLivro;

public class EmprestarExemplar extends Cenario {
	private TipoBiblioteca b;
	private TipoIdLivro idLivro;
	private TipoIdExemplar idExemplar;

	public void dadoQue() {
		existeUmaBiblioteca();
		aBibliotecaPossuiUmLivro();
		oLivroPossuiUmExemplarDisponivel();
	}

	public void quando() {
		emprestarOExemplar();
	}

	public void então() {
		oExemplarFicaráEmprestado();
		oPrazoDeDevolucaoÉDe15Dias();
	}

	private void existeUmaBiblioteca() {
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central;15"));
	}

	private void aBibliotecaPossuiUmLivro() {
		idLivro = b.adicionar(new DadosLivro("Título Livro;Nome Autor"));
	}

	private void oLivroPossuiUmExemplarDisponivel() {
		idExemplar = b.adicionarExemplar(idLivro, new DadosExemplarArquivavel(
				"3a Edição;1999;Numero Chamada"));
	}

	private void emprestarOExemplar() {
		b.emprestar(idExemplar);
	}

	@Test
	public void oExemplarFicaráEmprestado() {
		assertTrue(EMPRESTADO.equals(b.obterEstadoLivro(idExemplar)));
	}

	@Test
	public void oPrazoDeDevolucaoÉDe15Dias() {		
		assertEquals(new PrazoDevolucao(15), b.obterPrazoDevolucao(idExemplar));
	}
}

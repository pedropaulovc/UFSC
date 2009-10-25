package historia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static producao.livro.EstadoEmprestimo.EMPRESTADO;

import java.util.Date;
import java.util.GregorianCalendar;

import infra.Cenario;

import org.junit.Test;

import producao.Biblioteca;
import producao.ConfiguracaoBiblioteca;
import producao.TipoBiblioteca;
import producao.livro.DadosExemplarArquivavel;
import producao.livro.DadosLivro;
import producao.livro.TipoIdentificacaoExemplar;
import producao.livro.TipoIdentificacaoLivro;

public class EmprestarExemplar extends Cenario {
	private TipoBiblioteca b;
	private TipoIdentificacaoLivro idLivro;
	private TipoIdentificacaoExemplar idExemplar;

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
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central"));
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
		assertTrue(EMPRESTADO.equals(b.obterEstadoExemplar(idExemplar)));
	}

	@Test
	public void oPrazoDeDevolucaoÉDe15Dias() {
		GregorianCalendar calendario = new GregorianCalendar();
		calendario.set(GregorianCalendar.DAY_OF_MONTH, 15);
		Date quinzeDiasDepois = calendario.getTime();
		
		assertEquals(quinzeDiasDepois, b.prazoDevolucao(idExemplar));
	}
}

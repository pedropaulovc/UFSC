package biblioteca.historia;

import infra.Cenario;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import biblioteca.producao.AcervoDeLivro;
import biblioteca.producao.Livro;
import biblioteca.producao.Livro.EstadoEmprestimo;

public class DataDevolucaoDe15Dias extends Cenario {

	private AcervoDeLivro acervo;
	private Livro livroCriado;

	public void dadoQue() {
		existeUmAcervoDeLivro();
		háUmLivroEmprestadoNoAcervo();
	}

	public void quando() {
		éPedidaDataDevolução();
	}

	public void então() {
		dataDevoluçãoÉDe15Dias();
	}

	private void existeUmAcervoDeLivro() {
		acervo = new AcervoDeLivro();

	}

	private void criarLivroEmprestado() {
		livroCriado = new Livro();
		livroCriado.alterarTitulo("Livro do José");
		livroCriado.alterarAnoPublicacao(1900);
		livroCriado.alterarAutor("Autor José");
		livroCriado.alterarEditora("Editora do Brasil");
		livroCriado.alterarEstado(EstadoEmprestimo.EMPRESTADO);
	}

	private void háUmLivroEmprestadoNoAcervo() {
		criarLivroEmprestado();
		acervo.adicionar(livroCriado);
	}

	private void éPedidaDataDevolução() {
		livroCriado.obterDataDevolucao();
	}

	private Date criarData15DiasAdiante() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 15);
		return cal.getTime();
	}
	
	@Test
	public void dataDevoluçãoÉDe15Dias() {
		Assert.assertEquals(livroCriado.obterDataDevolucao(), criarData15DiasAdiante());
	}

}

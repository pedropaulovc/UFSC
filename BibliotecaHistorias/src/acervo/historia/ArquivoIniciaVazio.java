package acervo.historia;

import infra.Cenario;
import junit.framework.Assert;

import org.junit.Test;

import biblioteca.producao.AcervoDeLivro;
import biblioteca.producao.Livro;

import acervo.producao.TipoAcervo;


public class ArquivoIniciaVazio extends Cenario {
	
	private TipoAcervo<Livro> acervo;

	public void dadoQue() {
		existeUmAcervoDeLivros();
	}

	public void quando() {
		pedeTamanhoAcervo();
	}

	public void então() {
		tamanhoAcervoÉVazio();
	}

	private void existeUmAcervoDeLivros() {
		acervo = new AcervoDeLivro();
	}
	
	private void pedeTamanhoAcervo() {
		acervo.tamanho();
	}
	
	@Test
	public void tamanhoAcervoÉVazio() {
		Assert.assertTrue(acervo.tamanho() == 0);	
	}

}

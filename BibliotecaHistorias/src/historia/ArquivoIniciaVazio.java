package historia;

import infra.Cenario;
import junit.framework.Assert;

import org.junit.Test;

import producao.Livro;
import producao.acervo.Acervo;
import producao.acervo.TipoAcervo;

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
		acervo = new Acervo<Livro>(Livro.class);
	}
	
	private void pedeTamanhoAcervo() {
		acervo.tamanho();
	}
	
	@Test
	public void tamanhoAcervoÉVazio() {
		Assert.assertTrue(acervo.tamanho() == 0);	
	}

}

package historia;

import junit.framework.Assert;

import org.junit.Test;

import producao.Livro;
import producao.acervo.AcervoDeLivro;

import infra.Cenario;

public class AdicionandoNovoLivro extends Cenario {

	private AcervoDeLivro acervo;
	private Livro livro;

	public void dadoQue() {
		existeUmAcervoDeLivros();
		existeUmLivro();
	}


	public void quando() {
		adicionaLivroNoAcervo();
	}

	public void então() {
		tamanhoAcervoAumentaUm();
		livroAdicionadoÉÚltimoDaLista();
	}

	private void existeUmAcervoDeLivros() {
		acervo = new AcervoDeLivro();
	}

	private void existeUmLivro() {
		livro = new Livro();
		livro.alterarTitulo("Livro do José");
		livro.alterarAnoPublicacao(1900);
		livro.alterarAutor("Autor José");
		livro.alterarEditora("Editora do Brasil");
	}
	
	private void adicionaLivroNoAcervo() {
		acervo.adicionar(livro);
	}

	@Test
	public void tamanhoAcervoAumentaUm() {
		Assert.assertTrue(acervo.tamanho() == 1);
	}

	@Test
	public void livroAdicionadoÉÚltimoDaLista() {
		Assert.assertSame(livro, acervo.obter(0));
	}

}

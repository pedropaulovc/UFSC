package acervo.historia;

import org.junit.Assert;
import org.junit.Test;

import biblioteca.producao.AcervoDeLivro;
import biblioteca.producao.Livro;



import infra.Cenario;

public class RemovendoArquivavel extends Cenario {
	private AcervoDeLivro acervo;
	private Livro livroCriado;

	public void dadoQue() {
		existeUmAcervoDeLivros();
		háUmLivroNoAcervo();
	}

	public void quando() {
		éRemovidoOLivro();
	}

	public void então() {
		tamanhoDoAcervoÉZero();
	}

	private void existeUmAcervoDeLivros() {
		acervo = new AcervoDeLivro();

	}

	private void criarLivro() {
		livroCriado = new Livro();
		livroCriado.alterarTitulo("Livro do José");
		livroCriado.alterarAnoPublicacao(1900);
		livroCriado.alterarAutor("Autor José");
		livroCriado.alterarEditora("Editora do Brasil");
	}

	private void háUmLivroNoAcervo() {
		criarLivro();
		acervo.adicionar(livroCriado);
	}

	private void éRemovidoOLivro() {
		acervo.remover(0);
	}

	@Test
	public void tamanhoDoAcervoÉZero() {
		Assert.assertTrue(acervo.tamanho() == 0);
	}
}

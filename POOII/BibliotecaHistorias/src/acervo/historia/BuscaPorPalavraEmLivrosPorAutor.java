package acervo.historia;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import biblioteca.producao.AcervoDeLivro;
import biblioteca.producao.Livro;


import infra.Cenario;

public class BuscaPorPalavraEmLivrosPorAutor extends Cenario {
	private AcervoDeLivro acervo;
	private Livro livroCriado;

	public void dadoQue() {
		existeUmAcervoDeLivros();
		háUmLivroNoAcervo();
	}

	public void quando() {
		buscadoLivroPorPalavraPorAutor();
	}

	public void então() {
		obtemListaDeLivrosCorrespondentes();
	}

	private void existeUmAcervoDeLivros() {
		acervo = new AcervoDeLivro();
	}

	private void criarLivro() {
		livroCriado = new Livro();
		livroCriado.alterarTitulo("Livro do José");
		livroCriado.alterarAnoPublicacao(1900);
		livroCriado.alterarAutor("Jose Dos Santos");
		livroCriado.alterarEditora("Editora do Brasil");
	}

	private void háUmLivroNoAcervo() {
		criarLivro();
		acervo.adicionar(livroCriado);
	}

	private void buscadoLivroPorPalavraPorAutor() {
		acervo.buscaAutorPorPalavra("Jose");
	}

	@Test
	public void obtemListaDeLivrosCorrespondentes() {
		List<Livro> listaEsperada = new ArrayList<Livro>();
		listaEsperada.add(livroCriado);
		Assert.assertEquals(listaEsperada, acervo.buscaAutorPorPalavra("Dos"));
	}
}

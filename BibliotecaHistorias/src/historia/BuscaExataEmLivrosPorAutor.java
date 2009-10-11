package historia;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import producao.Livro;
import producao.acervo.AcervoDeLivro;
import infra.Cenario;

public class BuscaExataEmLivrosPorAutor extends Cenario {
	private AcervoDeLivro acervo;
	private Livro livroCriado;

	public void dadoQue() {
		existeUmAcervoDeLivros();
		háUmLivroNoAcervo();
	}

	public void quando() {
		buscadoLivroPorAutor();
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
		livroCriado.alterarAutor("Autor José");
		livroCriado.alterarEditora("Editora do Brasil");
	}

	private void háUmLivroNoAcervo() {
		criarLivro();
		acervo.adicionar(livroCriado);
	}

	private void buscadoLivroPorAutor() {
		acervo.buscaExataAutor("Autor José");
	}

	@Test
	public void obtemListaDeLivrosCorrespondentes() {
		List<Livro> listaEsperada = new ArrayList<Livro>();
		listaEsperada.add(livroCriado);
		Assert.assertEquals(listaEsperada, acervo.buscaExataAutor("Autor José"));
	}
}

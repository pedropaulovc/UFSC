package historia;

import static org.junit.Assert.assertFalse;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.biblioteca.TipoBiblioteca;
import producao.livro.TipoLivro;
import producao.livro.id.TipoIdLivro;

public class LivrosDiferentesPossuemIdsDiferentes extends CenarioComBiblioteca {
	private TipoLivro livro1, livro2;
	private TipoBiblioteca b;
	private TipoIdLivro idLivro1, idLivro2;

	public void dadoQue() {
		existeUmaBiblioteca();
		existemDadosDeDoisLivros();
	}

	public void quando() {
		adicionarOsLivrosNaBiblioteca();
	}

	public void então() {
		osIdsDosLivrosSerãoDiferentes();
	}

	private void existeUmaBiblioteca() {
		b = obterBiblioteca();
	}

	private void existemDadosDeDoisLivros() {
		livro1 = obterLivro();
		livro2 = obterLivro();
	}

	private void adicionarOsLivrosNaBiblioteca() {
		idLivro1 = b.adicionar(livro1);
		idLivro2 = b.adicionar(livro2);
	}

	@Test
	public void osIdsDosLivrosSerãoDiferentes() {
		assertFalse(idLivro1.equals(idLivro2));
	}
}

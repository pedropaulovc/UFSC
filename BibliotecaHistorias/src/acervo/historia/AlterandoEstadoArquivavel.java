package acervo.historia;

import infra.Cenario;
import junit.framework.Assert;

import org.junit.Test;

import biblioteca.producao.AcervoDeLivro;
import biblioteca.producao.Livro;
import biblioteca.producao.Livro.EstadoEmprestimo;

public class AlterandoEstadoArquivavel extends Cenario {
	private AcervoDeLivro acervo;
	private Livro livroObtido;

	public void dadoQue() {
		existeUmAcervoDeLivros();
		háUmLivroNoAcervo();
	}

	public void quando() {
		alterarEstadoLivro();
	}

	public void então() {
		estadoSeráODefinido();
	}

	private void existeUmAcervoDeLivros() {
		acervo = new AcervoDeLivro();
	}

	private Livro criarLivro() {
		Livro livroCriado = new Livro();
		livroCriado.alterarTitulo("Livro do José");
		livroCriado.alterarAnoPublicacao(1900);
		livroCriado.alterarAutor("Autor José");
		livroCriado.alterarEditora("Editora do Brasil");
		
		return livroCriado;
	}

	private void háUmLivroNoAcervo() {
		acervo.adicionar(criarLivro());
	}

	private void alterarEstadoLivro() {
		livroObtido = acervo.obter(0);
		livroObtido.alterarEstado(EstadoEmprestimo.DISPONIVEL);
	}
	
	@Test
	public void estadoSeráODefinido() {
		Assert.assertSame(EstadoEmprestimo.DISPONIVEL, livroObtido.obterEstado());
	}
}

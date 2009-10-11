package acervo.historia;

import junit.framework.Assert;

import org.junit.Test;

import acervo.producao.Estado;
import biblioteca.producao.AcervoDeLivro;
import biblioteca.producao.Disponivel;
import biblioteca.producao.Livro;


import infra.Cenario;

public class AlterandoEstadoArquivavel extends Cenario {
	private AcervoDeLivro acervo;
	private Livro livroObtido;
	private Estado estado;

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
		livroObtido.alterarEstado(estado = new Disponivel());
	}
	
	@Test
	public void estadoSeráODefinido() {
		Assert.assertSame(estado, livroObtido.obterEstado());
	}
}

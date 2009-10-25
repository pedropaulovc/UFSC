package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.Biblioteca;
import producao.ConfiguracaoBiblioteca;
import producao.TipoBiblioteca;
import producao.livro.DadosLivro;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoIdentificacao;

public class RemoverLivro extends Cenario {
	private TipoBiblioteca b;
	private TipoDadosLivro dadosLivro;
	private TipoIdentificacao id;

	public void dadoQue() {
		existeUmaBibliotecaComUmLivro();
		conheceOIdDoLivro();
	}

	public void quando() {
		removeOLivro();
	}

	public void então() {
		bibliotecaFicaComNenhumLivro();
	}

	private void existeUmaBibliotecaComUmLivro() {
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central"));

		dadosLivro = new DadosLivro("Nome do Título;Nome do Autor");
		b.adicionar(dadosLivro);

		assertEquals(1, b.tamanho());
	}

	private void conheceOIdDoLivro() {
		id = dadosLivro.obterIdentificacao();
	}
	
	private void removeOLivro() {
		b.removerLivro(id);
	}

	@Test
	public void bibliotecaFicaComNenhumLivro() {
		assertEquals(0, b.tamanho());
	}
}

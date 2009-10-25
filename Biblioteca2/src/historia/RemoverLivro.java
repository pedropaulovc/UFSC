package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.Biblioteca;
import producao.ConfiguracaoBiblioteca;
import producao.TipoBiblioteca;
import producao.livro.DadosLivro;
import producao.livro.TipoIdentificacaoLivro;

public class RemoverLivro extends Cenario {
	private TipoBiblioteca b;
	private TipoIdentificacaoLivro id;

	public void dadoQue() {
		existeUmaBibliotecaComUmLivro();
	}

	public void quando() {
		removeOLivro();
	}

	public void então() {
		bibliotecaFicaComNenhumLivro();
	}

	private void existeUmaBibliotecaComUmLivro() {
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central;15"));

		id = b.adicionar(new DadosLivro("Nome do Título;Nome do Autor"));

		assertEquals(1, b.tamanho());
	}
	
	private void removeOLivro() {
		b.removerLivro(id);
	}

	@Test
	public void bibliotecaFicaComNenhumLivro() {
		assertEquals(0, b.tamanho());
	}
}

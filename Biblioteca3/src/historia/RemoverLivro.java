package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.biblioteca.Biblioteca;
import producao.biblioteca.TipoBiblioteca;
import producao.biblioteca.configuracao.ConfiguracaoBiblioteca;
import producao.livro.dados.DadosLivro;
import producao.livro.id.TipoIdLivro;

public class RemoverLivro extends Cenario {
	private TipoBiblioteca b;
	private TipoIdLivro id;

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

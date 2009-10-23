package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.Biblioteca;
import producao.ConfiguracaoBiblioteca;
import producao.TipoBiblioteca;
import producao.TipoConfiguracaoBiblioteca;
import producao.livro.DadosLivro;
import producao.livro.Editora;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEditora;
import producao.livro.TipoLivro;

public class RemoverLivro extends Cenario {
	private TipoBiblioteca b;
	private TipoLivro livro;

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
		TipoConfiguracaoBiblioteca configuração = new ConfiguracaoBiblioteca(
				"Biblioteca Central");
		b = new Biblioteca(configuração);
		
		TipoEditora editora = new Editora();
		TipoDadosLivro dados = new DadosLivro("Nome do Título;Nome do Autor");
		livro = editora.criarLivro(dados);
		
		b.adicionar(livro);
		
		assertEquals(1, b.tamanho());
	}

	private void removeOLivro() {
		b.removerLivro(1);
	}

	@Test
	public void bibliotecaFicaComNenhumLivro() {
		assertEquals(0, b.tamanho());
	}
}

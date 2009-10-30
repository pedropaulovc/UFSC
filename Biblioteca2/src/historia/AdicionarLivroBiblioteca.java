package historia;

import static org.junit.Assert.assertEquals;
import infra.Cenario;

import org.junit.Test;

import producao.biblioteca.Biblioteca;
import producao.biblioteca.TipoBiblioteca;
import producao.biblioteca.configuracao.ConfiguracaoBiblioteca;
import producao.livro.Livro;
import producao.livro.autor.Autor;
import producao.livro.dados.DadosLivro;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.exemplar.anoPublicacao.AnoPublicacao;
import producao.livro.exemplar.nomeEditora.NomeEditora;
import producao.livro.id.TipoIdLivro;
import producao.livro.titulo.Titulo;

public class AdicionarLivroBiblioteca extends Cenario {
	private TipoBiblioteca b;
	private TipoDadosLivro dados;
	private TipoIdLivro idLivro;
	private Livro livro;

	public void dadoQue() {
		existeUmaBibliotecaComNenhumLivro();
		existemDadosDeUmLivroArquivavel();
	}

	public void quando() {
		adicionaLivroNaBiblioteca();
	}

	public void então() {
		aBibliotecaPossuiUmLivro();
		éPossívelObterOLivroArmazenado();
	}

	@Test
	public void existeUmaBibliotecaComNenhumLivro() {
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central;15"));

		assertEquals(0, b.tamanho());
	}

	private void existemDadosDeUmLivroArquivavel() {
		dados = new DadosLivro(new Titulo("Titulo"), new Autor("Autor"),
				new NomeEditora("Editora"), new AnoPublicacao(1999));
		livro = new Livro(dados);
	}

	private void adicionaLivroNaBiblioteca() {
		idLivro = b.adicionar(livro);
	}

	@Test
	public void aBibliotecaPossuiUmLivro() {
		assertEquals(1, b.tamanho());
	}

	@Test
	public void éPossívelObterOLivroArmazenado() {
		assertEquals(livro, b.obterLivro(idLivro));
	}
}

package historia.biblioteca;

import static org.junit.Assert.assertEquals;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.dados.anoPublicacao.AnoPublicacao;
import producao.dados.autor.Autor;
import producao.dados.nomeEditora.NomeEditora;
import producao.dados.titulo.Titulo;
import producao.livro.TipoLivro;
import producao.livro.dados.DadosLivro;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.editora.TipoEditora;

public class CriarLivro extends CenarioComBiblioteca {
	private TipoLivro livro;
	private TipoEditora editora;
	private TipoDadosLivro dados;

	public void dadoQue() {
		existeUmaEditora();
		haDadosValidosDeUmLivro();
	}

	public void quando() {
		criarUmNovoLivroComOsDados();
	}

	public void então() {
		receboUmNovoLivroComOsMesmosDados();
	}

	private void existeUmaEditora() {
		editora = obterEditora();
	}

	private void haDadosValidosDeUmLivro() {
		dados = new DadosLivro(new Titulo("Titulo"), new Autor("Autor"),
				new NomeEditora("Editora"), new AnoPublicacao(1999));
	}

	private void criarUmNovoLivroComOsDados() {
		livro = editora.criarLivro(dados);
	}

	@Test
	public void receboUmNovoLivroComOsMesmosDados() {
		assertEquals(dados, livro.obterDados());
	}
}

package historia.biblioteca;

import static org.junit.Assert.assertEquals;
import infra.CenarioComBiblioteca;

import org.junit.Test;

import producao.dados.anoPublicacao.modelo.AnoPublicacao;
import producao.dados.autor.modelo.Autor;
import producao.dados.nome.modelo.Nome;
import producao.livro.TipoLivro;
import producao.livro.dados.DadosLivro;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.editora.Editora;

public class CriarLivro extends CenarioComBiblioteca {
	private TipoLivro livro;
	private Editora editora;
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
		dados = new DadosLivro(new Nome("Titulo"), new Autor("Autor"),
				new Nome("Editora"), new AnoPublicacao(1999));
	}

	private void criarUmNovoLivroComOsDados() {
		livro = editora.criarLivro(dados);
	}

	@Test
	public void receboUmNovoLivroComOsMesmosDados() {
		assertEquals(dados, livro.obterDados());
	}
}

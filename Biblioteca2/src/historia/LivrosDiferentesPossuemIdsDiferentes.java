package historia;

import static org.junit.Assert.assertFalse;
import infra.Cenario;

import org.junit.Test;

import producao.livro.DadosLivro;
import producao.livro.Editora;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEditora;
import producao.livro.TipoIdentificacaoLivro;
import producao.livro.TipoLivro;

public class LivrosDiferentesPossuemIdsDiferentes extends
		Cenario {

	private TipoDadosLivro dadosLivro2;
	private TipoDadosLivro dadosLivro1;
	private TipoLivro livro1;
	private TipoLivro livro2;

	public void dadoQue() {
		existemDadosDeDoisLivros();
	}

	public void quando() {
		criarDoisLivros();
	}

	public void então() {
		osIdsDosLivrosSerãoDiferentes();
	}

	private void existemDadosDeDoisLivros() {
		dadosLivro1 = new DadosLivro("Titulo;Autor");
		dadosLivro2 = new DadosLivro("Titulo;Autor");
	}

	private void criarDoisLivros() {
		TipoEditora editora = new Editora();
		
		livro1 = editora.criarLivro(dadosLivro1);
		livro2 = editora.criarLivro(dadosLivro2);
	}

	@Test
	public void osIdsDosLivrosSerãoDiferentes() {
		TipoIdentificacaoLivro idLivro1 = livro1.obterIdentificacao();
		TipoIdentificacaoLivro idLivro2 = livro2.obterIdentificacao();

		assertFalse(idLivro1.equals(idLivro2));
	}
}

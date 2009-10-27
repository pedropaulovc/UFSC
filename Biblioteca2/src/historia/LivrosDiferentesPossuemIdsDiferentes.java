package historia;

import static org.junit.Assert.assertFalse;
import infra.Cenario;

import org.junit.Test;

import producao.livro.TipoLivro;
import producao.livro.dados.DadosLivro;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.editora.Editora;
import producao.livro.editora.TipoEditora;
import producao.livro.id.TipoIdLivro;

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
		TipoIdLivro idLivro1 = livro1.obterId();
		TipoIdLivro idLivro2 = livro2.obterId();

		assertFalse(idLivro1.equals(idLivro2));
	}
}

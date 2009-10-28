package historia;

import static org.junit.Assert.assertFalse;
import infra.Cenario;

import org.junit.Test;

import producao.livro.dados.DadosLivro;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.editora.Editora;
import producao.livro.editora.TipoEditora;
import producao.livro.exemplar.TipoLivroComExemplaresNaoArquivaveis;
import producao.livro.exemplar.dados.DadosExemplarArquivavel;
import producao.livro.exemplar.id.TipoIdExemplar;

public class ExemplaresDiferentesPossuemIdsDiferentes extends Cenario {

	private TipoLivroComExemplaresNaoArquivaveis l;
	private TipoIdExemplar idExemplar1;
	private TipoIdExemplar idExemplar2;

	public void dadoQue() {
		existeUmLivroComExemplares();
	}

	public void quando() {
		adicionarDoisExemplaresAoLivro();
	}

	public void então() {
		osIdsDosExemplaresSerãoDiferentes();
	}

	private void existeUmLivroComExemplares() {
		TipoEditora editora = new Editora();

		TipoDadosLivro dadosLivro = new DadosLivro("Título;Autor");
		l = editora.criarLivroComExemplares(dadosLivro);
	}

	private void adicionarDoisExemplaresAoLivro() {
		idExemplar1 = l.adicionarExemplar(new DadosExemplarArquivavel(
				"Editora;1999;Numero Chamada"));

		idExemplar2 = l.adicionarExemplar(new DadosExemplarArquivavel(
		"Editora;1999;Numero Chamada"));
	}

	@Test
	public void osIdsDosExemplaresSerãoDiferentes() {
		assertFalse(idExemplar1.equals(idExemplar2));
	}
}

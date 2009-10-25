package historia;

import static org.junit.Assert.assertFalse;
import infra.Cenario;

import org.junit.Test;

import producao.livro.DadosExemplarArquivavel;
import producao.livro.DadosLivro;
import producao.livro.Editora;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEditora;
import producao.livro.TipoIdentificacaoExemplar;
import producao.livro.TipoLivroComExemplaresNaoArquivaveis;

public class ExemplaresDiferentesPossuemIdsDiferentes extends Cenario {

	private TipoLivroComExemplaresNaoArquivaveis l;
	private TipoIdentificacaoExemplar idExemplar1;
	private TipoIdentificacaoExemplar idExemplar2;

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

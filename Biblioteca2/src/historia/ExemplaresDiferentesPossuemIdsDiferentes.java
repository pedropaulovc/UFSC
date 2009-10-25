package historia;

import static org.junit.Assert.assertFalse;
import infra.Cenario;

import org.junit.Test;

import producao.livro.DadosExemplarArquivavel;
import producao.livro.DadosLivro;
import producao.livro.Editora;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEditora;
import producao.livro.TipoIdentificacao;
import producao.livro.TipoLivroComExemplaresNaoArquivaveis;

public class ExemplaresDiferentesPossuemIdsDiferentes extends
		Cenario {

	private TipoLivroComExemplaresNaoArquivaveis l;
	private DadosExemplarArquivavel dadosExemplar1;
	private DadosExemplarArquivavel dadosExemplar2;

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
		dadosExemplar1 = new DadosExemplarArquivavel(
				"Editora;1999;Numero Chamada");
		l.adicionarExemplar(dadosExemplar1);

		dadosExemplar2 = new DadosExemplarArquivavel(
				"Editora;1999;Numero Chamada");
		l.adicionarExemplar(dadosExemplar2);
	}

	@Test
	public void osIdsDosExemplaresSerãoDiferentes() {
		TipoIdentificacao idExemplar1 = dadosExemplar1.obterIdentificacao();
		TipoIdentificacao idExemplar2 = dadosExemplar2.obterIdentificacao();

		assertFalse(idExemplar1.equals(idExemplar2));
	}
}

package historia;

import static org.junit.Assert.assertFalse;
import infra.Cenario;

import org.junit.Test;

import producao.livro.DadosExemplar;
import producao.livro.DadosLivro;
import producao.livro.EditoraBiblioteca;
import producao.livro.TipoDadosExemplar;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEditoraBiblioteca;
import producao.livro.TipoIdentificacao;
import producao.livro.TipoLivroArquivavel;

public class ExemplaresDiferentesPossuemIdsDiferentes extends Cenario {
	private TipoLivroArquivavel l;

	public void dadoQue() {
		existeUmLivro();
	}

	public void quando() {
		adicionarDoisExemplaresAoLivro();
	}

	public void então() {
		osIdsDosExemplaresSerãoDiferentes();
	}

	private void existeUmLivro() {
		TipoEditoraBiblioteca editora = new EditoraBiblioteca();
		TipoDadosLivro dadosLivro = new DadosLivro("Título;Autor");
		l = editora.criarLivro(dadosLivro);
	}

	private void adicionarDoisExemplaresAoLivro() {
		TipoDadosExemplar dadosExemplar1 = new DadosExemplar("Editora;1999");
		l.adicionarExemplar(dadosExemplar1);

		TipoDadosExemplar dadosExemplar2 = new DadosExemplar("Editora;1999");
		l.adicionarExemplar(dadosExemplar2);
	}

	@Test
	public void osIdsDosExemplaresSerãoDiferentes() {
		TipoIdentificacao idExemplar1 = l.obterExemplar(1).obterId();
		TipoIdentificacao idExemplar2 = l.obterExemplar(2).obterId();

		assertFalse(idExemplar1.equals(idExemplar2));
	}
}

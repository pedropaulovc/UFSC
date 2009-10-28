package historia;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static producao.livro.exemplar.EstadoEmprestimo.*;
import producao.biblioteca.Biblioteca;
import producao.biblioteca.TipoBiblioteca;
import producao.biblioteca.configuracao.ConfiguracaoBiblioteca;
import producao.livro.dados.DadosLivro;
import producao.livro.exemplar.dados.DadosExemplarArquivavel;
import producao.livro.exemplar.id.TipoIdExemplar;
import producao.livro.id.TipoIdLivro;
import infra.Cenario;

public class TornarExemplarConsultaLocal extends Cenario {
	private TipoBiblioteca b;
	private TipoIdLivro idLivro;
	private TipoIdExemplar idExemplar;

	public void dadoQue() {
		existeUmaBiblioteca();
		aBibliotecaPossuiUmLivro();
		oLivroPossuiUmExemplar();
	}

	public void quando() {
		tornarOExemplarConsultaLocal();
	}

	public void então() {
		oExemplarTornaSeConsultaLocal();
	}

	private void existeUmaBiblioteca() {
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central;15"));
	}

	private void aBibliotecaPossuiUmLivro() {
		idLivro = b.adicionar(new DadosLivro("Titulo Livro;Autor"));
	}

	private void oLivroPossuiUmExemplar() {
		idExemplar = b.adicionarExemplar(idLivro, new DadosExemplarArquivavel("Editora;1999;Numero Chamada"));
	}

	private void tornarOExemplarConsultaLocal() {
		b.alterarEstado(idExemplar, CONSULTA_LOCAL);
	}

	@Test
	public void oExemplarTornaSeConsultaLocal() {
		assertEquals(CONSULTA_LOCAL, b.obterEstadoExemplar(idExemplar));
	}
}

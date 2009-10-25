package historia;

import infra.Cenario;
import producao.Biblioteca;
import producao.ConfiguracaoBiblioteca;
import producao.TipoBiblioteca;
import producao.livro.DadosExemplarArquivavel;
import producao.livro.DadosLivro;
import producao.livro.TipoIdentificacao;

public class EmprestarExemplar extends Cenario {
	private TipoBiblioteca b;
	private TipoIdentificacao idLivro;
	private TipoIdentificacao idExemplar;

	public void dadoQue() {
		existeUmaBiblioteca();
		aBibliotecaPossuiUmLivro();
		oLivroPossuiUmExemplarDisponivel();
	}

	public void quando() {
		emprestarOExemplar();
	}

	public void então() {
		oExemplarFicaráEmprestado();
		oPrazoDeDevolucaoÉDe15Dias();
	}

	private void existeUmaBiblioteca() {
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central"));
	}

	private void aBibliotecaPossuiUmLivro() {
		idLivro = b.adicionar(new DadosLivro("Título Livro;Nome Autor"));
	}

	private void oLivroPossuiUmExemplarDisponivel() {
		idExemplar = b.adicionarExemplar(idLivro, new DadosExemplarArquivavel(
				"3a Edição;1999;Numero Chamada"));
	}

	private void emprestarOExemplar() {
		//b.emprestar(idExemplar);
	}

	private void oExemplarFicaráEmprestado() {
		//b.obterEstadoExemplar(idExemplar);
	}

	private void oPrazoDeDevolucaoÉDe15Dias() {
		//b.prazoDevolucao(idExemplar);
	}
}

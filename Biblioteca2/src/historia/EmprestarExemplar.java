package historia;

import infra.Cenario;
import producao.Biblioteca;
import producao.ConfiguracaoBiblioteca;
import producao.TipoBiblioteca;
import producao.livro.DadosExemplarArquivavel;
import producao.livro.DadosLivro;

public class EmprestarExemplar extends Cenario {
	private TipoBiblioteca b;

	public void dadoQue() {
		existeUmaBiblioteca();
		aBibliotecaPossuiUmLivro();
		oLivroPossuiUmExemplarDisponivel();
		aIdentificacaoDoExemplarÉConhecida();
	}

	public void quando() {
		emprestarOExemplar();
	}

	public void então() {
		oExemplarFicaráEmprestado();
		oPrazoDeDevolcaoÉDe15Dias();
	}

	private void existeUmaBiblioteca() {
		b = new Biblioteca(new ConfiguracaoBiblioteca("Biblioteca Central"));
	}

	private void aBibliotecaPossuiUmLivro() {
		b.adicionar(new DadosLivro("Título Livro;Nome Autor"));
	}

	private void oLivroPossuiUmExemplarDisponivel() {
		b.adicionarExemplar(1, new DadosExemplarArquivavel("3a Edição;1999"));
	}

	private void aIdentificacaoDoExemplarÉConhecida() {

	}

	private void emprestarOExemplar() {
		// TODO Auto-generated method stub

	}

	private void oExemplarFicaráEmprestado() {
		// TODO Auto-generated method stub

	}

	private void oPrazoDeDevolcaoÉDe15Dias() {
		// TODO Auto-generated method stub

	}
}

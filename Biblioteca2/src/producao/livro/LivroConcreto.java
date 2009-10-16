package producao.livro;

import java.util.List;

import producao.documento.AnoPublicacao;
import producao.documento.Autor;
import producao.documento.DocumentoConcreto;
import producao.documento.Edicao;
import producao.documento.Editora;
import producao.documento.NumeroChamada;
import producao.documento.Titulo;

public class LivroConcreto extends DocumentoConcreto implements Livro {
	private Titulo titulo;
	private List<Autor> listaAutores;
	private Edicao edicao;
	private AnoPublicacao anoPublicacao;
	private NumeroChamada numeroChamada;
	private Editora editora;

	public AnoPublicacao obterAnoPublicacao() {
		return anoPublicacao;
	}

	public List<Autor> obterAutores() {
		return listaAutores;
	}

	public Edicao obterEdicao() {
		return edicao;
	}

	public Editora obterEditora() {
		return editora;

	}

	public NumeroChamada obterNumeroChamada() {
		return numeroChamada;

	}

	public Titulo obterTitulo() {
		return titulo;
	}

	public void alterarAnoPublicacao(AnoPublicacao anoPublicacao) {
		this.anoPublicacao = anoPublicacao;

	}

	public void alterarEdicao(Edicao edicao) {
		this.edicao = edicao;

	}

	public void alterarEditora(Editora editora) {
		this.editora = editora;

	}

	public void alterarListaAutores(List<Autor> listaAutores) {
		this.listaAutores = listaAutores;

	}

	public void alterarNumeroChamada(NumeroChamada numeroChamada) {
		this.numeroChamada = numeroChamada;

	}

	public void alterarTitulo(Titulo titulo) {
		this.titulo = titulo;

	}
}

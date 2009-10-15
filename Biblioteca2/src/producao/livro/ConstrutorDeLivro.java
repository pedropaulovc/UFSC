package producao.livro;

import java.util.ArrayList;
import java.util.List;

import producao.documento.AnoPublicacao;
import producao.documento.Autor;
import producao.documento.Edicao;
import producao.documento.Editora;
import producao.documento.NumeroChamada;
import producao.documento.Titulo;

public class ConstrutorDeLivro {

	private Titulo titulo;
	private List<Autor> listaAutores;
	private Edicao edicao;
	private AnoPublicacao anoPublicacao;
	private NumeroChamada numeroChamada;
	private Editora editora;

	public ConstrutorDeLivro(){
		listaAutores = new ArrayList<Autor>();
	}
	
	public void alterarTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public void alterarAutor(Autor autor) {
		this.listaAutores.add(autor);
	}
	
	public void alterarAutor(List<Autor> listaAutores){
		this.listaAutores = listaAutores;
	}

	public void alterarEdicao(Edicao edicao) {
		this.edicao = edicao;
	}

	public void alterarAnoPublicacao(AnoPublicacao anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public void alterarNumeroChamada(NumeroChamada numeroChamada) {
		this.numeroChamada = numeroChamada;
	}

	public void alterarEditora(Editora editora) {
		this.editora = editora;
	}

	public Livro obterLivro() {
		Livro l = new LivroConcreto();
		
		l.alterarTitulo(titulo);
		l.alterarListaAutores(listaAutores);
		l.alterarEdicao(edicao);
		l.alterarAnoPublicacao(anoPublicacao);
		l.alterarNumeroChamada(numeroChamada);
		l.alterarEditora(editora);
		
		return l;
	}

}

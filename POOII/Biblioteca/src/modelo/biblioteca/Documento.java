package modelo.biblioteca;

import util.AdaptadorDeString;
import modelo.biblioteca.arquivaveis.Arquivavel;

public class Documento {
	private String titulo;
	private String autor;
	private ListaDe<Edicao> edicoes;
	private Arquivavel tipo;

	public Documento(String titulo, String autor, Arquivavel tipo, Edicao edicao) {
		this.titulo = titulo;
		this.autor = autor;
		this.tipo = tipo;
		this.edicoes = new ListaDe<Edicao>();
		this.edicoes.adicionar(edicao);
	}

	public Documento(String titulo, String autor, Arquivavel tipo,
			ListaDe<Edicao> edicoes) {
		this.titulo = titulo;
		this.autor = autor;
		this.tipo = tipo;
		this.edicoes = edicoes;
	}

	public void alterarAutor(String autor) {
		this.autor = autor;
	}

	public void alterarTiulo(String titulo) {
		this.titulo = titulo;
	}

	public String obterAutor() {
		return autor;
	}

	public String obterTitulo() {
		return titulo;
	}

	public void alterarEdicoes(ListaDe<Edicao> edicoes) {
		this.edicoes = edicoes;
	}

	public ListaDe<Edicao> obterEdicoes() {
		return edicoes.clone();
	}

	public void alterarTipo(Arquivavel tipo) {
		this.tipo = tipo;
	}

	public Arquivavel obterTipo() {
		return tipo;
	}

	public String toString() {
		return titulo.toUpperCase()
				+ ", "
				+ AdaptadorDeString.adaptarParaMinusculasComEspacos(tipo
						.toString()) + " do autor " + autor + ". Há "
				+ edicoes.tamanho() + " edições desse documento.";
	}

	public Documento clone() {
		return new Documento(titulo, autor, tipo, edicoes.clone());
	}
}

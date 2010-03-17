package modelo.biblioteca;

import visao.biblioteca.VisaoBiblioteca;

public class Biblioteca {
	private String nome;
	private ListaDe<Documento> acervo;
	private VisaoBiblioteca visao;

	public Biblioteca(String nome, VisaoBiblioteca visao) {
		this.nome = nome;
		this.visao = visao;
		acervo = new ListaDe<Documento>();
		atualizarEstatisticas();
	}

	public String obterNome() {
		return nome;
	}

	public int tamanhoAcervo() {
		return acervo.tamanho();
	}

	public void adicionar(Documento documento) {
		acervo.adicionar(documento);
		atualizarEstatisticas();
		exibirAcervo();
	}

	public Documento obter(int a) {
		return acervo.obter(a);
	}

	public void remover(int a) {
		acervo.remover(a);
		atualizarEstatisticas();
	}

	public String toString() {
		return nome + ". Possui acervo de " + tamanhoAcervo() + " documentos.";
	}

	public void atualizarEstatisticas() {
		visao.atualizarEstatisticas(toString());
	}
	
	public void exibirAcervo(){
		visao.atualizarAcervo(acervo);
	}
}
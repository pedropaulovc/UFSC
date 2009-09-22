package modelo.biblioteca;

import modelo.biblioteca.arquivaveis.Arquivavel;
import visao.biblioteca.VisaoBiblioteca;

public class Biblioteca {
	private String nome;
	private ListaDe<Arquivavel> acervo;
	private VisaoBiblioteca visao;

	public Biblioteca(String nome, VisaoBiblioteca visao) {
		this.nome = nome;
		this.visao = visao;
		acervo = new ListaDe<Arquivavel>();
		atualizarEstatisticas();
	}

	public String obterNome() {
		return nome;
	}

	public int tamanhoAcervo() {
		return acervo.tamanho();
	}

	public boolean adicionar(Arquivavel a) {
		boolean foiAdicionado = acervo.adicionar(a);
		atualizarEstatisticas();
		return foiAdicionado;
	}

	public Arquivavel obter(int a) {
		return acervo.obter(a).clone();
	}

	public Arquivavel remover(int a) {
		Arquivavel removido =  acervo.remover(a).clone();
		atualizarEstatisticas();
		return removido;
	}

	public String toString() {
		return nome + ". Possui acervo de " + tamanhoAcervo() + " documentos.";
	}

	public void atualizarEstatisticas() {
		visao.atualizarEstatisticas(toString());
	}
}
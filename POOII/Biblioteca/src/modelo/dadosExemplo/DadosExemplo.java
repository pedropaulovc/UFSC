package modelo.dadosExemplo;

import modelo.biblioteca.Biblioteca;
import modelo.biblioteca.Documento;
import modelo.biblioteca.Edicao;
import modelo.biblioteca.Exemplar;
import modelo.biblioteca.NumeroChamada;
import modelo.biblioteca.arquivaveis.Arquivavel;
import modelo.biblioteca.estadosEmprestimo.Situacao;

public class DadosExemplo {
	private Biblioteca biblioteca;

	public DadosExemplo(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	
	public void popularBiblioteca(){
		Exemplar exemplar = new Exemplar(Situacao.EMPRESTADO, "Estante 2");
		Edicao edicao = new Edicao(exemplar, new NumeroChamada("1234.33(44)"), 2009);
		Documento documento = new Documento("Cálculo B", "Stewart, James", Arquivavel.LIVRO, edicao);
		
		Exemplar exemplar2 = new Exemplar(Situacao.DISPONÍVEL, "Estante 3");
		Edicao edicao2 = new Edicao(exemplar2, new NumeroChamada("2233.44(12)"), 2005);
		Documento documento2 = new Documento("Telix", "Melgarejo, Luís Fernando Bier", Arquivavel.DISSERTAÇÃO ,edicao2);

		biblioteca.adicionar(documento);
		biblioteca.adicionar(documento2);
	}

}

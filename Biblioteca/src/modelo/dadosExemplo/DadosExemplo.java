package modelo.dadosExemplo;

import modelo.biblioteca.Biblioteca;
import modelo.biblioteca.Documento;
import modelo.biblioteca.Edicao;
import modelo.biblioteca.Exemplar;
import modelo.biblioteca.NumeroChamada;
import modelo.biblioteca.arquivaveis.Dissertacao;
import modelo.biblioteca.arquivaveis.Livro;
import modelo.biblioteca.situacoesEmprestimo.Disponivel;
import modelo.biblioteca.situacoesEmprestimo.Emprestado;

public class DadosExemplo {
	private Biblioteca biblioteca;

	public DadosExemplo(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	
	public void popularBiblioteca(){
		Exemplar exemplar = new Exemplar(2, new Emprestado(), "Estante 2");
		Edicao edicao = new Edicao(exemplar, new NumeroChamada("1234.33(44)"), 2009);
		Documento documento = new Documento("Cálculo B", "Stewart, James", edicao);
		Livro livro = new Livro(documento, 4);
		
		Exemplar exemplar2 = new Exemplar(1, new Disponivel(), "Estante 3");
		Edicao edicao2 = new Edicao(exemplar2, new NumeroChamada("2233.44(12)"), 2005);
		Documento documento2 = new Documento("Telix", "Melgarejo, Luís Fernando Bier", edicao2);
		Dissertacao dissertacao = new Dissertacao(documento2, "Mazzucco Júnior, José");

		biblioteca.adicionar(livro);
		biblioteca.adicionar(dissertacao);
	}

}

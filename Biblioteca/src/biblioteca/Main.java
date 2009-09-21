package biblioteca;

import biblioteca.arquivaveis.Dissertacao;
import biblioteca.arquivaveis.Livro;
import biblioteca.situacoes.Situacao;


public class Main {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca("Biblioteca Central");
		
		Exemplar exemplar = new Exemplar(2, new Situacao(), "Estante 2");
		Edicao edicao = new Edicao(exemplar, new NumeroChamada("1234.33(44)"), 2009);
		Documento documento = new Documento("Cálculo B", "Stewart, James", edicao);
		Livro livro = new Livro(documento, 4);
		
		Exemplar exemplar2 = new Exemplar(1, new Situacao(), "Estante 3");
		Edicao edicao2 = new Edicao(exemplar2, new NumeroChamada("2233.44(12)"), 2005);
		Documento documento2 = new Documento("Telix", "Melgarejo, Luís Fernando Bier", edicao2);
		Dissertacao dissertacao = new Dissertacao(documento2, "Mazzucco Júnior, José");
		
		biblioteca.adicionar(livro);
		biblioteca.adicionar(dissertacao);
		
		System.out.println(biblioteca.toString());
		System.out.println(livro.toString());
		System.out.println(dissertacao.toString());
	}
}

package controle;

import visao.FormularioBiblioteca;
import visao.VisaoBiblioteca;
import biblioteca.Biblioteca;
import biblioteca.Documento;
import biblioteca.Edicao;
import biblioteca.Exemplar;
import biblioteca.NumeroChamada;
import biblioteca.arquivaveis.Livro;
import biblioteca.situacoesEmprestimo.Emprestado;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.eventos.nomes.NomeDeEventosSimples;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorEnvioDados extends TratadorDixAbstrato {

	private Biblioteca biblioteca;
	private FormularioBiblioteca formulario;

	public TratadorEnvioDados(Biblioteca biblioteca, VisaoBiblioteca visao) {
		this.biblioteca = biblioteca;
		formulario = visao.obterFormulario();
	}

	public void seDito(EventoSimples evento) {
		if (evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)) {
			/*Exemplar exemplar = new Exemplar(formulario.obterVolume(),
					new LOREM(), formulario.obterLocalizacao());
			Edicao edicao = new Edicao(exemplar, new NumeroChamada(formulario
					.obterNumeroChamada()), Integer.parseInt(formulario
					.obterAnoPublicacao()));
			Documento documento = new Documento(formulario.obterTitulo(),
					formulario.obterAutor(), edicao);
			Livro livro = new Livro(documento, Integer.parseInt(formulario
					.obterNumeroCapitulos()));*/
		}
	}
}

package controle.biblioteca;

import visao.biblioteca.VisaoBiblioteca;
import modelo.biblioteca.Biblioteca;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.eventos.nomes.NomeDeEventosSimples;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorEnvioDados extends TratadorDixAbstrato {

	private AdaptadorFormulario adaptadorFormulario;
	private Biblioteca biblioteca;

	public TratadorEnvioDados(Biblioteca biblioteca, VisaoBiblioteca visao) {
		this.adaptadorFormulario = new AdaptadorFormulario(visao);
		this.biblioteca = biblioteca;
	}

	public void seDito(EventoSimples evento) {
		if (evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)) {
			biblioteca.adicionar(adaptadorFormulario.adaptar());
		}
	}
}

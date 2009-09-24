package controle.biblioteca;

import visao.biblioteca.VisaoBiblioteca;
import modelo.biblioteca.Biblioteca;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.eventos.nomes.NomeDeEventosSimples;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorEnvioDados extends TratadorDixAbstrato {

	private AdaptadorFormulario adaptadorFormulario;

	public TratadorEnvioDados(Biblioteca biblioteca, VisaoBiblioteca visao) {
		this.adaptadorFormulario = new AdaptadorFormulario(biblioteca, visao);
	}

	public void seDito(EventoSimples evento) {
		if (evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)) {
			adaptadorFormulario.adaptar();
		}
	}
}

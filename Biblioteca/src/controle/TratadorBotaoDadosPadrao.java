package controle;

import biblioteca.Biblioteca;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.eventos.nomes.NomeDeEventosSimples;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorBotaoDadosPadrao extends TratadorDixAbstrato {
	private Biblioteca biblioteca;
	public TratadorBotaoDadosPadrao(Biblioteca biblioteca, PaginaDix pagina) {
		this.biblioteca = biblioteca;
	}

	@Override
	public void seDito(EventoSimples evento) {
		if (evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)) {
			System.out.println(biblioteca.toString());
		}
	}
}
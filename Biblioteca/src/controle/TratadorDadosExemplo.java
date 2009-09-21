package controle;

import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.eventos.nomes.NomeDeEventosSimples;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorDadosExemplo extends TratadorDixAbstrato {
	public void seDito(EventoSimples evento){
		if(evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)){
			
		}
	}
}

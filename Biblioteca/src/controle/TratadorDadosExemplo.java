package controle;

import dadosExemplo.DadosDeExemplo;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.eventos.nomes.NomeDeEventosSimples;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorDadosExemplo extends TratadorDixAbstrato {
	private DadosDeExemplo modelo;

	public TratadorDadosExemplo(DadosDeExemplo modelo) {
		this.modelo = modelo;
	}

	public void seDito(EventoSimples evento){
		if(evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)){
			
		}
	}
}

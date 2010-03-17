package controle.DadosExemplo;

import modelo.dadosExemplo.DadosExemplo;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.eventos.nomes.NomeDeEventosSimples;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorDadosExemplo extends TratadorDixAbstrato {
	private DadosExemplo modelo;

	public TratadorDadosExemplo(DadosExemplo modelo) {
		this.modelo = modelo;
	}

	public void seDito(EventoSimples evento) {
		if (evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)) {
			modelo.popularBiblioteca();
		}
	}
}

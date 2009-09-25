package controle;

import modelo.CitacaoAleatoria;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.eventos.nomes.NomeDeEventosSimples;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorCitacaoAleatoria extends TratadorDixAbstrato {
	
	private CitacaoAleatoria ca;

	public TratadorCitacaoAleatoria(CitacaoAleatoria ca){
		this.ca = ca;
	}
	
	@Override
	public void seDito(EventoSimples evento) {
		if (evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)
				&& ca.qtdCitacoes() > 0) {
			ca.obterCitacaoAleatoria();
		}
	}

}

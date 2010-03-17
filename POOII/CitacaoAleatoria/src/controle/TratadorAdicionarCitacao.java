package controle;

import modelo.CitacaoAleatoria;
import visao.VisaoDix;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.eventos.nomes.NomeDeEventosSimples;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorAdicionarCitacao extends TratadorDixAbstrato {
	
	private CitacaoAleatoria ca;
	private VisaoDix visao;

	public TratadorAdicionarCitacao(CitacaoAleatoria ca, VisaoDix visao){
		this.ca = ca;
		this.visao = visao;
	}
	
	@Override
	public void seDito(EventoSimples evento) {
		if (evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)) {
			ca.adicionarCitacao(visao.obterCitacaoDigitada());
		}
	}
}

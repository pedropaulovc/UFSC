package visao.dadosExemplo;

import controle.DadosExemplo.TratadorDadosExemplo;
import edugraf.jadix.fachada.PaginaDix;

public class VisaoDadosExemplo {
	private BotaoDadosExemplo botao;
	

	public VisaoDadosExemplo(PaginaDix pagina) {
		botao = new BotaoDadosExemplo(pagina);
	}

	public void adicionarTratador(TratadorDadosExemplo tratador){
		botao.adicionarTratadorDeEventos(tratador);
	}
	
}

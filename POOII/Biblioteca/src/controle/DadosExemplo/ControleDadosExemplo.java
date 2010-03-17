package controle.DadosExemplo;

import modelo.dadosExemplo.DadosExemplo;
import visao.dadosExemplo.VisaoDadosExemplo;

public class ControleDadosExemplo {

	private DadosExemplo dadosExemplo;
	private VisaoDadosExemplo visaoDadosExemplo;

	public ControleDadosExemplo(DadosExemplo dadosExemplo,
			VisaoDadosExemplo visaoDadosDeExemplo) {
		this.dadosExemplo = dadosExemplo;
		this.visaoDadosExemplo = visaoDadosDeExemplo;
		adicionarTratadorDeEvento();
	}

	private void adicionarTratadorDeEvento() {
		visaoDadosExemplo.adicionarTratador(new TratadorDadosExemplo(dadosExemplo));
		
	}

}

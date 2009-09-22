package visaoDadosExemplo;

import controleDadosExemplo.TratadorDadosExemplo;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class VisaoDadosExemplo {
	private PaginaDix pagina;
	private ComponenteDix botaoDadosExemplo;

	public VisaoDadosExemplo(PaginaDix pagina) {
		this.pagina = pagina;
		criarBotaoDadosExemplo();
	}

	public void adicionarTratador(TratadorDadosExemplo tratador){
		botaoDadosExemplo.adicionarTratadorDeEventos(tratador);
	}
	
	private ComponenteDix criarBotaoDadosExemplo() {
		botaoDadosExemplo = pagina.criarComponente(TiposDeComponentesDix.BOTÃO, "botaoDadosExemplo");
		botaoDadosExemplo.fixarTopo(50).fixarEsquerda(200).fixarTexto("Usar Dados de Exemplo");
		return botaoDadosExemplo;
	}
	
}

package visao.dadosExemplo;

import controle.DadosExemplo.TratadorDadosExemplo;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class BotaoDadosExemplo {
	private ComponenteDix botaoDadosExemplo;
	private PaginaDix pagina;
	
	public BotaoDadosExemplo(PaginaDix pagina) {
		this.pagina = pagina;
		criarBotao();
	}

	private void criarBotao() {
		botaoDadosExemplo = pagina.criarComponente(TiposDeComponentesDix.BOTÃO, "botaoDadosExemplo");
		botaoDadosExemplo.fixarTopo(50).fixarEsquerda(200).fixarTexto("Usar Dados de Exemplo");
	}

	public void adicionarTratadorDeEventos(TratadorDadosExemplo tratador) {
		botaoDadosExemplo.adicionarTratadorDeEventos(tratador);
	}
	
}

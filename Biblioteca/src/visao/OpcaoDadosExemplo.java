package visao;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;


public class OpcaoDadosExemplo {
	private PaginaDix pagina;

	public OpcaoDadosExemplo(PaginaDix pagina) {
		this.pagina = pagina;
		criarBotaoDadosExemplo();
	}

	private ComponenteDix criarBotaoDadosExemplo() {
		ComponenteDix botaoDadosExemplo = pagina.criarComponente(TiposDeComponentesDix.BOTÃO, "botaoDadosExemplo");
		botaoDadosExemplo.fixarTopo(30).fixarEsquerda(100).fixarTexto("Usar Dados Padrão");
		return botaoDadosExemplo;
	}
}

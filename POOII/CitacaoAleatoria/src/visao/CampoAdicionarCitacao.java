package visao;

import edugraf.jadix.componentesDix.TipoComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class CampoAdicionarCitacao {

	private PaginaDix pagina;
	private TipoComponenteDix etiquetaAdicione;
	private TipoComponenteDix campoAdicione;
	private TipoComponenteDix botaoAdicione;

	public CampoAdicionarCitacao(PaginaDix pagina) {
		this.pagina = pagina;
		exibir();
	}

	private void exibir() {
		exibirEtiqueta();
		exibirCampo();
		exibirBotao();
	}
	
	public String obterTexto(){
		return campoAdicione.obterTexto();
	}

	private void exibirBotao() {
		botaoAdicione = pagina.criarComponente(TiposDeComponentesDix.BOTÃO,
				"botaoAdicione");
		botaoAdicione.fixarTopo(180).fixarEsquerda(330).fixarTexto("OK");
	}

	private void exibirCampo() {
		campoAdicione = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "campoAdicione");
		campoAdicione.fixarTopo(180).fixarEsquerda(20).fixarLargura(300);
	}

	private void exibirEtiqueta() {
		etiquetaAdicione = pagina.criarComponente(
				TiposDeComponentesDix.ETIQUETA, "etiquetaAdicione");
		etiquetaAdicione.fixarTopo(160).fixarEsquerda(20).fixarTexto(
				"Adicione uma citação: ");
	}

	public void adicionarTratadorDeEventos(TratadorDixAbstrato tratador) {
		botaoAdicione.adicionarTratadorDeEventos(tratador);
		
	}

}

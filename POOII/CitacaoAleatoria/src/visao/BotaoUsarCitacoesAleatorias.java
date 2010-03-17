package visao;

import edugraf.jadix.componentesDix.TipoComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class BotaoUsarCitacoesAleatorias {

	private PaginaDix pagina;
	private TipoComponenteDix botaoGereCitacoes;
	private TipoComponenteDix gereCitacoes;

	public BotaoUsarCitacoesAleatorias(PaginaDix pagina) {
		this.pagina = pagina;
		exibir();
	}

	private void exibir() {
		exibirEtiqueta();

		exibirBotao();

	}

	private void exibirBotao() {
		botaoGereCitacoes = pagina.criarComponente(TiposDeComponentesDix.BOTÃO,
				"botaoGereCitacoes");
		botaoGereCitacoes.fixarTopo(40).fixarEsquerda(200).fixarTexto("OK");

	}

	private void exibirEtiqueta() {
		gereCitacoes = pagina.criarComponente(TiposDeComponentesDix.ETIQUETA,
				"gereCitacoes");
		gereCitacoes.fixarTopo(40).fixarEsquerda(20).fixarTexto(
				"Utilize citações predefinidas: ");

	}
	
	public void adicionarTratadorDeEventos(TratadorDixAbstrato tratador){
		botaoGereCitacoes.adicionarTratadorDeEventos(tratador);
	}

}

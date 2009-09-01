package visaoDix;

import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class DixLeitorFeed extends Aplique {
	private PaginaDix pagina;
	private CaixaUrl caixaUrl;
	private ComponenteDix tituloFeed;
	
	public DixLeitorFeed(PaginaDix pagina){
		this.pagina = pagina;
		criarElementos();
		formatarElementos();
	}

	private void criarElementos(){
		caixaUrl = new CaixaUrl(pagina);
		tituloFeed = pagina.criarComponente(TiposDeComponentesDix.ETIQUETA,
				"etiquetaTeste");
	}
	
	private void formatarElementos() {
		formatarCaixaUrl();
		formatarTituloFeed();
	}

	private void formatarTituloFeed() {
		String saudacao = "Exemplo: http://feeds.feedburner.com/meiobit";
		tituloFeed.fixarTopo(150).fixarEsquerda(300).fixarTexto(saudacao);
	}

	private void formatarCaixaUrl() {
		String legendaUrlFeed = "Insira na caixa o endereço do feed RSS";
		String legendaBotaoOk = "OK";
		
		caixaUrl.urlFeed.fixarLegenda(legendaUrlFeed).fixarTopo(100)
				.fixarEsquerda(300).fixarLargura(300);

		caixaUrl.botaoOk.fixarTopo(99).fixarEsquerda(610).fixarTexto(
				legendaBotaoOk);
	}
	
	public ComponenteDix getUrlFeed() {
		return caixaUrl.getUrlFeed();
	}
	
	public ComponenteDix getBotaoOk() {
		return caixaUrl.getBotaoOk();
	}

	public ComponenteDix getTituloFeed() {
		return tituloFeed;
	}

	private class CaixaUrl {
		private ComponenteDix urlFeed, botaoOk;

		public ComponenteDix getUrlFeed() {
			return urlFeed;
		}

		public ComponenteDix getBotaoOk() {
			return botaoOk;
		}

		public CaixaUrl(PaginaDix pagina) {
			urlFeed = pagina.criarComponente(
					TiposDeComponentesDix.CAMPO_DE_TEXTO, "urlFeed");
			botaoOk = pagina.criarComponente(TiposDeComponentesDix.BOTÃO,
					"botaoOk");
		}
	}
}
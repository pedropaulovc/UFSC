package controleJadix;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import visaoDix.DixLeitorFeed;

import leitorFeeds.Feed;
import leitorFeeds.LeitorFeed;

import edugraf.jadix.ApliqueSemPichador;
import edugraf.jadix.eventos.EventoDeTeclado;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.eventos.nomes.NomeDeEventosSimples;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class ApliqueLeitorFeed extends ApliqueSemPichador {

	private Feed feed;
	private DixLeitorFeed construtor;
	private PaginaDix pagina = this.obterPaginaDix();

	public void iniciar() {
		construtor = new DixLeitorFeed(pagina);
		adicionarTratadoresDeEventos();
	}

	private void adicionarTratadoresDeEventos() {
		construtor.getBotaoOk().adicionarTratadorDeEventos(
				new TratadorBotaoAtualizarFeedExibido());
		construtor.getUrlFeed().adicionarTratadorDeEventos(
				new TratadorCaixaUrlAtualizarFeedExibido());
	}

	private abstract class TratadorAbstratoExibidorFeed extends
			TratadorDixAbstrato {

		public Feed obterFeed() {
			try {
				feed = new LeitorFeed(construtor.getUrlFeed().obterTexto())
						.obterFeed();
			} catch (MalformedURLException e) {
				construtor.getTituloFeed().fixarTexto("URL mal formada: " + e.getMessage());
			} catch (IOException e) {
				construtor.getTituloFeed().fixarTexto("Problema de IO: " + e.getMessage());
			} catch (ParserConfigurationException e) {
				construtor.getTituloFeed().fixarTexto(
						"Problema na configuração do analisador: " + e.getMessage());
			} catch (SAXException e) {
				construtor.getTituloFeed().fixarTexto(
						"Problema com o analisador SAX: " + e.getMessage());
			}
			return feed;
		}

		public void exibirFeed(Feed feed) {
			if (feed.obterTitulo() != null)
				construtor.getTituloFeed().fixarTexto(feed.obterTitulo());
			
			for (int i = 0; i < feed.obterQtdItens(); i++) {
				ComponenteDix titulo = pagina.criarComponente(
						TiposDeComponentesDix.ETIQUETA,
						"titulo." + Math.random() + i);
				titulo.fixarTopo(220 + 20 * i).fixarEsquerda(20).fixarTexto(
						feed.obterTituloItem(i));
				titulo.fixarURI(feed.obterLinkItem(i));
			}
		}
	}

	private class TratadorBotaoAtualizarFeedExibido extends
			TratadorAbstratoExibidorFeed {

		@Override
		public void seDito(EventoSimples evento) {
			if (evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)) {
				exibirFeed(obterFeed());
			}
		}
	}

	private class TratadorCaixaUrlAtualizarFeedExibido extends
			TratadorAbstratoExibidorFeed {

		@Override
		public void seDito(EventoDeTeclado evento) {
			if (evento.obterTecla() == 13) {
				exibirFeed(obterFeed());
			}
		}
	}
}
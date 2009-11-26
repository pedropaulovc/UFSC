package producao.formulario.visao;

import java.awt.Rectangle;

import edugraf.jadix.componentesDix.TipoComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class BotaoEnviar {

	private TipoComponenteDix componente;

	public BotaoEnviar(PaginaDix pagina, Rectangle r, String legenda) {
		criarCampo(pagina, r, legenda);
	}

	public void criarCampo(PaginaDix pagina, Rectangle r, String legenda) {
		componente = pagina.criarComponente(TiposDeComponentesDix.BOTÃO,
				"botaoEnviar");
		componente.fixarTopo((int) r.getX()).fixarEsquerda((int) r.getY())
				.fixarLargura((int) r.getWidth()).fixarTexto(legenda);
	}

	public void tornarVisivel() {
		componente.tornarVisivel();
	}

	public void tornarInvisivel() {
		componente.tornarInvisivel();
	}

	public void adicionarTratadorEventos(TratadorDixAbstrato tratador) {
		componente.adicionarTratadorDeEventos(tratador);
	}
}

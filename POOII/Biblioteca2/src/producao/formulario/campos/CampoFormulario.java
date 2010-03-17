package producao.formulario.campos;

import java.awt.Rectangle;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class CampoFormulario {
	private ComponenteDix componente;

	public CampoFormulario(PaginaDix pagina, Rectangle r, String legenda) {
		criarCampo(pagina, r, legenda);
	}

	public void criarCampo(PaginaDix pagina, Rectangle r,
			String legenda) {
		componente = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "campo_" + Math.random());
		componente.fixarTopo((int) r.getX()).fixarEsquerda((int) r.getY())
				.fixarLargura((int) r.getWidth()).fixarLegenda(legenda);
	}

	public String obterTexto() {
		return componente.obterTexto();
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

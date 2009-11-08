package producao.formulario.campos;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public abstract class CampoAbstratoFormulario implements
		TipoCampoAbstratoFormulario {
	private ComponenteDix componente;

	public CampoAbstratoFormulario(PaginaDix pagina) {
		componente = criarCampo(pagina);
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

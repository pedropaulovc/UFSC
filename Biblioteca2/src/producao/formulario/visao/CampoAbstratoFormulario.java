package producao.formulario.visao;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public abstract class CampoAbstratoFormulario {
	private ComponenteDix componente;
	
	public CampoAbstratoFormulario(PaginaDix pagina){
		componente = criarCampo(pagina);
	}

	public abstract ComponenteDix criarCampo(PaginaDix pagina);
	
	public String obterTexto(){
		return componente.obterTexto();
	}
	
	public void tornarVisivel() {
		componente.tornarVisivel();
	}
	
	public void tornarInvisivel() {
		componente.tornarInvisivel();
	}
	
	public void adicionarTratadorEventos(TratadorDixAbstrato tratador){
		componente.adicionarTratadorDeEventos(tratador);
	}
}

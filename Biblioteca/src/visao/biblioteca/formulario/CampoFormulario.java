package visao.biblioteca.formulario;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public abstract class CampoFormulario {
	private ComponenteDix componente;
	
	public CampoFormulario(PaginaDix pagina){
		criarCampo(pagina, componente);
	}

	public abstract void criarCampo(PaginaDix pagina, ComponenteDix componente);
	
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

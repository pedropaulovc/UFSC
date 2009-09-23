package visao.biblioteca.formulario;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class Orientador extends CampoAbstratoFormulario {
	public Orientador(PaginaDix pagina) {
		super(pagina);
	}

	public ComponenteDix criarCampo(PaginaDix pagina) {
		ComponenteDix componente = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "orientador");
		componente.fixarTopo(370).fixarEsquerda(20).fixarLargura(500)
				.tornarInvisivel().fixarLegenda("Orientador");		
		return componente;
	}

}

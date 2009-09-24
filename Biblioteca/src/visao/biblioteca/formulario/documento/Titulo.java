package visao.biblioteca.formulario.documento;

import visao.biblioteca.formulario.CampoAbstratoFormulario;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class Titulo extends CampoAbstratoFormulario {
	public Titulo(PaginaDix pagina) {
		super(pagina);
	}

	@Override
	public ComponenteDix criarCampo(PaginaDix pagina) {
		ComponenteDix componente = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "tituloDocumento");
		componente.fixarTopo(120).fixarEsquerda(20).fixarLargura(500)
				.fixarLegenda("Título");		
		return componente;
	}
}

package visao.biblioteca.formulario.documento;

import visao.biblioteca.formulario.CampoAbstratoFormulario;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class Autor extends CampoAbstratoFormulario {

	public Autor(PaginaDix pagina) {
		super(pagina);
	}

	@Override
	public ComponenteDix criarCampo(PaginaDix pagina) {
		ComponenteDix componente = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "autorDocumento");
		componente.fixarTopo(170).fixarEsquerda(20).fixarLargura(500)
				.fixarLegenda("Autor");
		return componente;
	}
}

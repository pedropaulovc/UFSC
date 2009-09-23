package visao.biblioteca.formulario;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class NumeroCapitulos extends CampoAbstratoFormulario {

	public NumeroCapitulos(PaginaDix pagina) {
		super(pagina);
	}

	@Override
	public ComponenteDix criarCampo(PaginaDix pagina) {
		ComponenteDix componente = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "numeroCapitulos");
		componente.fixarTopo(220).fixarEsquerda(410).fixarLargura(100)
				.fixarLegenda("Número Capítulos");
		return componente;
	}

}

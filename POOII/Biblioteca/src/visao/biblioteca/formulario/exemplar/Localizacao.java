package visao.biblioteca.formulario.exemplar;

import visao.biblioteca.formulario.CampoAbstratoFormulario;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class Localizacao extends CampoAbstratoFormulario {

	public Localizacao(PaginaDix pagina) {
		super(pagina);
	}

	@Override
	public ComponenteDix criarCampo(PaginaDix pagina) {
		ComponenteDix componente = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "localizacao");
		componente.fixarTopo(270).fixarEsquerda(20).fixarLargura(500)
				.fixarLegenda("Localização Na Estante");
		return componente;
	}

}

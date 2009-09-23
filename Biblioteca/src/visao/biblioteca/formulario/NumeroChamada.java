package visao.biblioteca.formulario;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class NumeroChamada extends CampoAbstratoFormulario {

	public NumeroChamada(PaginaDix pagina) {
		super(pagina);
	}

	@Override
	public ComponenteDix criarCampo(PaginaDix pagina) {
		ComponenteDix componente = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "numeroChamada");
		componente.fixarTopo(220).fixarEsquerda(20).fixarLargura(100)
				.fixarLegenda("Número Chamada");
		return componente;
	}

}

package producao.dados.numeroChamada.visao;

import producao.formulario.campos.CampoAbstratoFormulario;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class VisaoNumeroChamada extends CampoAbstratoFormulario implements
		TipoVisaoNumeroChamada {

	public VisaoNumeroChamada(PaginaDix pagina) {
		super(pagina);
	}

	public ComponenteDix criarCampo(PaginaDix pagina) {
		ComponenteDix componente = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "numeroChamada");
		componente.fixarTopo(220).fixarEsquerda(20).fixarLargura(100)
				.fixarLegenda("Número Chamada");
		return componente;
	}

}

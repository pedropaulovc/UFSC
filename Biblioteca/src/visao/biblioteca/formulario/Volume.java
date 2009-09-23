package visao.biblioteca.formulario;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class Volume extends CampoFormulario {

	public Volume(PaginaDix pagina) {
		super(pagina);
	}

	@Override
	public void criarCampo(PaginaDix pagina, ComponenteDix componente) {
		componente = pagina.criarComponente(TiposDeComponentesDix.CAMPO_DE_TEXTO,
				"volume");
		componente.fixarTopo(220).fixarEsquerda(150).fixarLargura(110)
				.fixarLegenda("Volume");

	}

}

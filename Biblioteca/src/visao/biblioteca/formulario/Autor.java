package visao.biblioteca.formulario;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class Autor extends CampoFormulario {

	public Autor(PaginaDix pagina) {
		super(pagina);
	}

	@Override
	public void criarCampo(PaginaDix pagina, ComponenteDix componente) {
		componente = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "autorDocumento");
		componente.fixarTopo(170).fixarEsquerda(20).fixarLargura(500)
				.fixarLegenda("Autor");
	}
}

package producao.dados.autor.visao;

import producao.formulario.campos.CampoAbstratoFormulario;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class VisaoAutor extends CampoAbstratoFormulario {

	public VisaoAutor(PaginaDix pagina) {
		super(pagina);
	}

	public ComponenteDix criarCampo(PaginaDix pagina) {
		ComponenteDix componente = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "autorDocumento");
		componente.fixarTopo(170).fixarEsquerda(20).fixarLargura(500)
				.fixarLegenda("Autor");
		return componente;
	}

}

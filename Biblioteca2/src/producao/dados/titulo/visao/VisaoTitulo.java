package producao.dados.titulo.visao;

import producao.formulario.campos.CampoAbstratoFormulario;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class VisaoTitulo extends CampoAbstratoFormulario implements TipoVisaoTitulo {

	public VisaoTitulo(PaginaDix pagina) {
		super(pagina);
	}

	public ComponenteDix criarCampo(PaginaDix pagina) {
		ComponenteDix componente = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "tituloDocumento");
		componente.fixarTopo(120).fixarEsquerda(20).fixarLargura(500)
				.fixarLegenda("Título");		
		return componente;
	}

}

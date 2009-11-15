package producao.dados.nome.visao;

import producao.formulario.campos.CampoAbstratoFormulario;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class VisaoCampoNome extends CampoAbstratoFormulario implements
		TipoVisaoCampoNome {

	public VisaoCampoNome(PaginaDix pagina) {
		super(pagina);
	}

	public ComponenteDix criarCampo(PaginaDix pagina) {
		ComponenteDix componente = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "campoNome_"
						+ Math.random());
		componente.fixarTopo(120).fixarEsquerda(20).fixarLargura(500)
				.fixarLegenda("Título");
		return componente;
	}

}

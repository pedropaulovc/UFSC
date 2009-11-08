package producao.dados.anoPublicacao.visao;

import producao.formulario.campos.CampoAbstratoFormulario;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class VisaoAnoPublicacao extends CampoAbstratoFormulario implements
		TipoVisaoAnoPublicacao {

	public VisaoAnoPublicacao(PaginaDix pagina) {
		super(pagina);
	}

	public ComponenteDix criarCampo(PaginaDix pagina) {
		ComponenteDix componente = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "anoPublicacao");
		componente.fixarTopo(220).fixarEsquerda(280).fixarLargura(100)
				.fixarLegenda("Ano Publicação");
		return componente;
	}

}

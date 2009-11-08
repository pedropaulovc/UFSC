package producao.dados.nomeEditora.visao;

import producao.formulario.campos.CampoAbstratoFormulario;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class VisaoNomeEditora extends CampoAbstratoFormulario implements
		TipoVisaoNomeEditora {

	public VisaoNomeEditora(PaginaDix pagina) {
		super(pagina);
	}

	public ComponenteDix criarCampo(PaginaDix pagina) {
		ComponenteDix componente = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "nomeEditora");
		componente.fixarTopo(270).fixarEsquerda(20).fixarLargura(500)
				.fixarLegenda("Nome da Editora do Livro");
		return componente;
	}

}

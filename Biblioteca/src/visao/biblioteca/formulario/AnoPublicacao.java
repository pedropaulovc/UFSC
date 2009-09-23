package visao.biblioteca.formulario;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class AnoPublicacao extends CampoFormulario {

	public AnoPublicacao(PaginaDix pagina) {
		super(pagina);
	}

	@Override
	public void criarCampo(PaginaDix pagina, ComponenteDix componente) {
		componente = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "anoPublicacao");
		componente.fixarTopo(220).fixarEsquerda(280).fixarLargura(100)
				.fixarLegenda("Ano Publicação");
	}

}

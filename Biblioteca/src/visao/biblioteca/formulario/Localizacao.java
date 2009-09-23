package visao.biblioteca.formulario;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class Localizacao extends CampoFormulario {

	public Localizacao(PaginaDix pagina) {
		super(pagina);
	}

	@Override
	public void criarCampo(PaginaDix pagina, ComponenteDix componente) {
		componente = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "localizacao");
		componente.fixarTopo(270).fixarEsquerda(20).fixarLargura(500)
				.fixarLegenda("Localização Na Estante");
	}

}

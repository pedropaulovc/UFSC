package producao.formulario.visao;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class BotaoEnviar extends CampoAbstratoFormulario {

	public BotaoEnviar(PaginaDix pagina) {
		super(pagina);
	}

	@Override
	public ComponenteDix criarCampo(PaginaDix pagina) {
		ComponenteDix componente = pagina.criarComponente(TiposDeComponentesDix.BOTÃO,
				"botaoEnviar");
		componente.fixarTopo(425).fixarEsquerda(200).fixarLargura(150)
				.fixarTexto("Enviar");
		return componente;
	}
}

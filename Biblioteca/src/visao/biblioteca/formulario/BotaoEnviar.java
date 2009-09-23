package visao.biblioteca.formulario;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class BotaoEnviar extends CampoFormulario {

	public BotaoEnviar(PaginaDix pagina) {
		super(pagina);
	}

	@Override
	public void criarCampo(PaginaDix pagina, ComponenteDix componente) {
		componente = pagina.criarComponente(TiposDeComponentesDix.BOTÃO,
				"botaoEnviar");
		componente.fixarTopo(425).fixarEsquerda(200).fixarLargura(150)
				.fixarTexto("Enviar");
	}
}

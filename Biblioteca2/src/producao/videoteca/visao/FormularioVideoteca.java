package producao.videoteca.visao;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import producao.formulario.visao.BotaoEnviar;
import producao.videoteca.controle.TratadorEnvioDadosVideoteca;
import edugraf.jadix.fachada.PaginaDix;

public class FormularioVideoteca {

	private PaginaDix pagina;
	private CamposFormularioVideoteca camposFormulario;
	private BotaoEnviar botaoEnviar;

	public FormularioVideoteca(PaginaDix pagina) {
		this.pagina = pagina;
		montarFormulario();
	}

	private void montarFormulario() {
		camposFormulario = new CamposFormularioVideoteca(pagina);
		botaoEnviar = new BotaoEnviar(pagina, new Rectangle(
				new Point(400, 200), new Dimension(150, 0)), "Enviar");
	}

	public void adicionarTratadorEnvioDados(TratadorEnvioDadosVideoteca tratador) {
		botaoEnviar.adicionarTratadorEventos(tratador);
	}

	public CamposFormularioVideoteca obterCampos() {
		return camposFormulario;
	}

}

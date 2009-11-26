package producao.formulario.visao;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import producao.formulario.campos.CamposFormularioBiblioteca;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class FormularioBiblioteca {
	private PaginaDix pagina;
	private BotaoEnviar botaoEnviar;
	private CamposFormularioBiblioteca camposFormulario;

	public FormularioBiblioteca(PaginaDix pagina) {
		this.pagina = pagina;
		montarFormulario();
	}

	private void montarFormulario() {
		camposFormulario = new CamposFormularioBiblioteca(pagina);
		botaoEnviar = new BotaoEnviar(pagina, new Rectangle(
				new Point(300, 200), new Dimension(150, 0)), "Enviar");
	}

	public void adicionarTratadorEnvioDados(TratadorDixAbstrato tratador) {
		botaoEnviar.adicionarTratadorEventos(tratador);
	}

	public CamposFormularioBiblioteca obterCampos() {
		return camposFormulario;
	}

}

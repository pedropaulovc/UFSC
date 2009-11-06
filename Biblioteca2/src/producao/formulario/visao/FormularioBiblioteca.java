package producao.formulario.visao;

import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class FormularioBiblioteca implements TipoFormularioBiblioteca {
	private PaginaDix pagina;
	private BotaoEnviar botaoEnviar;
	private TipoCamposFormulario camposFormulario;

	public FormularioBiblioteca(PaginaDix pagina) {
		this.pagina = pagina;
		montarFormulario();
	}

	private void montarFormulario() {
		camposFormulario = new CamposFormulario(pagina);
		botaoEnviar = new BotaoEnviar(pagina);
	}

	public void adicionarTratadorEnvioDados(TratadorDixAbstrato tratador) {
		botaoEnviar.adicionarTratadorEventos(tratador);
	}

	public TipoCamposFormulario obterCamposFormulario() {
		return camposFormulario;
	}

}

package producao.formulario.visao;

import producao.formulario.campos.CamposFormulario;
import producao.formulario.campos.TipoCamposFormulario;
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

	public TipoCamposFormulario obterCampos() {
		return camposFormulario;
	}

}

package producao.formulario.visao;

import producao.biblioteca.controle.TratadorEnvioDados;
import producao.formulario.campos.CamposFormularioVideoteca;
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
		botaoEnviar = new BotaoEnviar(pagina);
	}

	public void adicionarTratadorEnvioDados(TratadorEnvioDados tratador) {
		botaoEnviar.adicionarTratadorEventos(tratador);
	}

	public CamposFormularioVideoteca obterCampos() {
		return camposFormulario;
	}

}

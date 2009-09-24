package visao.biblioteca.formulario;

import visao.biblioteca.formulario.documento.CamposDocumento;
import visao.biblioteca.formulario.edicao.CamposEdicao;
import visao.biblioteca.formulario.exemplar.CamposExemplar;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class FormularioBiblioteca {
	private PaginaDix pagina;
	private BotaoEnviar botaoEnviar;
	private CamposDocumento camposDocumento;
	private CamposEdicao camposEdicao;
	private CamposExemplar camposExemplar;

	public FormularioBiblioteca(PaginaDix pagina) {
		this.pagina = pagina;
		montarFormulario();
	}

	private void montarFormulario() {
		camposDocumento = new CamposDocumento(pagina);
		camposEdicao = new CamposEdicao(pagina);
		camposExemplar = new CamposExemplar(pagina);
		botaoEnviar = new BotaoEnviar(pagina);
	}

	public void adicionarTratadorEnvioDados(TratadorDixAbstrato tratador) {
		botaoEnviar.adicionarTratadorEventos(tratador);
	}

	public CamposDocumento obterCamposDocumento() {
		return camposDocumento;
	}

	public CamposEdicao obterCamposEdicao() {
		return camposEdicao;
	}

	public CamposExemplar obterCamposExemplar() {
		return camposExemplar;
	}

	public FormularioBiblioteca clone() {
		try {
			return (FormularioBiblioteca) super.clone();
		} catch (CloneNotSupportedException excecao) {
			return this;
		}
	}
}

package visao;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class FormularioBiblioteca {
	private PaginaDix pagina;

	public FormularioBiblioteca(PaginaDix pagina) {
		this.pagina = pagina;
		montarFormulario();
	}

	private void montarFormulario() {
		ComponenteDix tituloDocumento = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "tituloDocumento");
		tituloDocumento.fixarTopo(60).fixarEsquerda(20).fixarTexto("Título do documento");

	}

}

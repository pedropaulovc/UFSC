package visao;

import edugraf.jadix.componentesDix.TipoComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class Titulo {

	private PaginaDix pagina;

	public Titulo(PaginaDix pagina) {
		this.pagina = pagina;
		exibir();
	}

	private void exibir() {
		TipoComponenteDix titulo = pagina.criarComponente(
				TiposDeComponentesDix.ETIQUETA, "titulo");
		titulo.fixarTopo(20).fixarEsquerda(500).fixarTexto(
				"Citações Aleatórias");
	}

}

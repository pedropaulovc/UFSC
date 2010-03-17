package visao.biblioteca;

import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class TituloPagina {
	private PaginaDix pagina;
	
	public TituloPagina(PaginaDix pagina) {
		this.pagina = pagina;
		criarTitulo();
	}

	private void criarTitulo() {
		pagina.criarComponente(TiposDeComponentesDix.ETIQUETA, "tituloPagina")
		.fixarTopo(20).fixarEsquerda(500).fixarTexto("Sistema de Controle de Biblioteca");
	}
}
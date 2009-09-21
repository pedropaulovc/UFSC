package visao;

import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class Titulo {
	private PaginaDix pagina;
	
	public Titulo(PaginaDix pagina) {
		this.pagina = pagina;
		criarTitulo();
	}

	private void criarTitulo() {
		pagina.criarComponente(TiposDeComponentesDix.ETIQUETA, "tituloPagina")
		.fixarTopo(20).fixarEsquerda(500).fixarTexto("Sistema de Controle de Biblioteca");
	}
}
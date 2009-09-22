package visao;

import edugraf.jadix.componentesDix.TipoComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class Estatisticas {
	
	private PaginaDix pagina;
	private TipoComponenteDix estatisticasBiblioteca;

	public Estatisticas(PaginaDix pagina) {
		this.pagina = pagina;
		criarEtiquetaEstatisticas();
	}

	private void criarEtiquetaEstatisticas(){
		estatisticasBiblioteca = pagina.criarComponente(
				TiposDeComponentesDix.ETIQUETA, "estatisticasBiblioteca");
		estatisticasBiblioteca.fixarTopo(500).fixarEsquerda(20);
	}
	
	public void exibirEstatisticas(String texto){
		estatisticasBiblioteca.fixarTexto(texto);
	}
}

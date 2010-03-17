package producao.estatistica;

import edugraf.jadix.componentesDix.TipoComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class VisaoEstatisticas {

	private PaginaDix pagina;
	private TipoComponenteDix estatisticasBiblioteca;

	public VisaoEstatisticas(PaginaDix pagina) {
		this.pagina = pagina;
		criarEstatisticaSimples();
	}

	private void criarEstatisticaSimples() {
		estatisticasBiblioteca = pagina.criarComponente(
				TiposDeComponentesDix.ETIQUETA, "estatisticasBiblioteca");
		estatisticasBiblioteca.fixarTopo(500).fixarEsquerda(20);
	}

	public void exibir(String texto) {
		estatisticasBiblioteca.fixarTexto(texto);
	}

}

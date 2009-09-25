package visao.biblioteca.acervo;

import modelo.biblioteca.Exemplar;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class VisaoExemplar {

	private Exemplar exemplar;
	private int numeroExemplar;
	private PaginaDix pagina;

	public VisaoExemplar(Exemplar exemplar, int numeroExemplar, PaginaDix pagina) {
		this.exemplar = exemplar;
		this.numeroExemplar = numeroExemplar;
		this.pagina = pagina;
		exibir();
	}

	private void exibir() {
		ComponenteDix etiquetaExemplar = pagina.criarComponente(
				TiposDeComponentesDix.ETIQUETA, "exemplar_" + Math.random()
				+ "_" + numeroExemplar);
		etiquetaExemplar.fixarTopo(240).fixarEsquerda(
				550 + 90 + 320 * numeroExemplar).fixarLargura(300);
		etiquetaExemplar.fixarTexto(exemplar.toString());
	}

}

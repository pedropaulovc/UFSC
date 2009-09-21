package visao;

import edugraf.jadix.componentesDix.TipoComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

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
		estatisticasBiblioteca.fixarTopo(500).fixarEsquerda(20).fixarTexto("Estatísticas da biblioteca");
	}
	
	public void exibirEstatisticas(String texto){
		estatisticasBiblioteca.fixarTexto(texto);
	}

	public void adicionarTratadorEventos(TratadorDixAbstrato tratador) {
		estatisticasBiblioteca.adicionarTratadorDeEventos(tratador);
	}
}

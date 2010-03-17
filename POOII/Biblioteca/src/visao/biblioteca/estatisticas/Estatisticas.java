package visao.biblioteca.estatisticas;

import edugraf.jadix.fachada.PaginaDix;

public class Estatisticas {
	
	private EstatisticaSimples estatisticasSimples;

	public Estatisticas(PaginaDix pagina) {
		estatisticasSimples = new EstatisticaSimples(pagina);
	}
	
	public void exibirEstatisticas(String texto){
		estatisticasSimples.exibir(texto);
	}
}

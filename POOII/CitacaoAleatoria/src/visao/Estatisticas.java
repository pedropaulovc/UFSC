package visao;

import edugraf.jadix.componentesDix.TipoComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class Estatisticas {
	private PaginaDix pagina;
	private TipoComponenteDix qtdCitacoes;

	public Estatisticas(PaginaDix pagina) {
		this.pagina = pagina;
		exibir();
	}

	private void exibir() {
		qtdCitacoes = pagina.criarComponente(
				TiposDeComponentesDix.ETIQUETA, "qtdCitacoes");
		qtdCitacoes.fixarTopo(80).fixarEsquerda(20).fixarTexto(
				"Quantidade de citações: " + "0");
	}

	public void atualizar(int qtd) {
			qtdCitacoes.fixarTexto("Quantidade de citações: " + qtd);
	}
}

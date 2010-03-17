package visao;

import edugraf.jadix.componentesDix.TipoComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class VisaoExibirCitacaoAleatoria {

	private PaginaDix pagina;
	private TipoComponenteDix citacaoAleatoria;

	public VisaoExibirCitacaoAleatoria(PaginaDix pagina) {
		this.pagina = pagina;
		exibir();
	}

	private void exibir() {
		citacaoAleatoria = pagina.criarComponente(
				TiposDeComponentesDix.ETIQUETA, "citacaoAleatoria");
		citacaoAleatoria.fixarTopo(120).fixarEsquerda(20).fixarTexto(
				"Clique para gerar uma citação aleatória");
	}

	public void atualizar(String citacao) {
		citacaoAleatoria.fixarTexto("Clique para gerar uma citação aleatória: "
				+ citacao);
	}

	public void adicionarTratadorDeEventos(TratadorDixAbstrato tratador) {
		citacaoAleatoria.adicionarTratadorDeEventos(tratador);
		
	}

}

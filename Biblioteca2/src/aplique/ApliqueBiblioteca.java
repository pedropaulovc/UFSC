package aplique;

import aplique.selecaoSistemas.VisaoSelecaoSistemas;
import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.PaginaDix;

public class ApliqueBiblioteca extends Aplique {
	private PaginaDix pagina;

	public void iniciar() {
		pagina = this.obterPaginaDix();

		criarSelecaoSistemas();
	}

	private void criarSelecaoSistemas() {
		new VisaoSelecaoSistemas(pagina);
	}

}
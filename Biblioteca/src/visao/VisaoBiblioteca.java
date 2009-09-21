package visao;

import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.PaginaDix;

public class VisaoBiblioteca extends Aplique {
	public VisaoBiblioteca(PaginaDix pagina) {
		new Titulo(pagina);
		new FormularioBiblioteca(pagina);
	}
}
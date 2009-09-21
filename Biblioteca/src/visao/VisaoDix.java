package visao;

import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.PaginaDix;

public class VisaoDix extends Aplique {
	public VisaoDix(PaginaDix pagina) {
		new Titulo(pagina);
		new FormularioBiblioteca(pagina);
	}
}
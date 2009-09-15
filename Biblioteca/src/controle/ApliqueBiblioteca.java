package controle;

import visao.VisaoDix;
import biblioteca.Biblioteca;
import edugraf.jadix.Aplique;

public class ApliqueBiblioteca extends Aplique {
	@Override
	public void iniciar() {
		new Biblioteca("Biblioteca Central");
		new VisaoDix(this.obterPaginaDix());
	}
}
package controle;

import visao.VisaoBiblioteca;
import biblioteca.Biblioteca;

public class ControleBiblioteca {

	private Biblioteca biblioteca;
	private VisaoBiblioteca visaoBiblioteca;

	public ControleBiblioteca(Biblioteca biblioteca,
			VisaoBiblioteca visaoBiblioteca) {
		this.biblioteca = biblioteca;
		this.visaoBiblioteca = visaoBiblioteca;
	}

}

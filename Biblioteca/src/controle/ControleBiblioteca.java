package controle;

import visao.VisaoBiblioteca;
import biblioteca.Biblioteca;

public class ControleBiblioteca {

	private Biblioteca biblioteca;
	private VisaoBiblioteca visao;

	public ControleBiblioteca(Biblioteca biblioteca,
			VisaoBiblioteca visaoBiblioteca) {
		this.biblioteca = biblioteca;
		this.visao = visaoBiblioteca;

		adicionarTratadoresEventos();
	}

	private void adicionarTratadoresEventos() {
		
	}

}

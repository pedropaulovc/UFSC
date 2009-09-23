package controle.biblioteca;

import modelo.biblioteca.Biblioteca;
import visao.biblioteca.VisaoBiblioteca;

public class ControleBiblioteca {

	private Biblioteca biblioteca;
	private VisaoBiblioteca visao;

	public ControleBiblioteca(Biblioteca biblioteca,
			VisaoBiblioteca visaoBiblioteca) {
		this.biblioteca = biblioteca;
		this.visao = visaoBiblioteca;

		//adicionarTratadoresEventos();
	}

/*	private void adicionarTratadoresEventos() {
		visao.adicionarTratadorEnvioDados(new TratadorEnvioDados(biblioteca, visao));
		visao.adicionarTratadorTipoDocumento(new TratadorTipoDocumento(visao));
	}*/

}

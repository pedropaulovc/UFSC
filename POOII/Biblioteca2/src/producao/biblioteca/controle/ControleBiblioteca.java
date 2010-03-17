package producao.biblioteca.controle;

import producao.biblioteca.modelo.Biblioteca;
import producao.biblioteca.visao.VisaoBiblioteca;

public class ControleBiblioteca {

	private Biblioteca b;
	private VisaoBiblioteca v;

	public ControleBiblioteca(Biblioteca biblioteca, VisaoBiblioteca visao) {
		this.b = biblioteca;
		this.v = visao;

		adicionarTratadoresEventos();
	}

	private void adicionarTratadoresEventos() {
		v.adicionarTratadorEnvioDados(new TratadorEnvioDadosBiblioteca(b, v));
	}

}

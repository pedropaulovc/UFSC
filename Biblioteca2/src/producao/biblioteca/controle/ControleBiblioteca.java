package producao.biblioteca.controle;

import producao.biblioteca.modelo.TipoBiblioteca;
import producao.biblioteca.visao.TipoVisaoBiblioteca;

public class ControleBiblioteca implements TipoControleBiblioteca {

	private TipoBiblioteca b;
	private TipoVisaoBiblioteca v;

	public ControleBiblioteca(TipoBiblioteca biblioteca,
			TipoVisaoBiblioteca visao) {
		this.b = biblioteca;
		this.v = visao;
		
		adicionarTratadoresEventos();
	}

	private void adicionarTratadoresEventos() {
		v.adicionarTratadorEnvioDados(new TratadorEnvioDados(b, v));		
	}

}

package producao.controle.biblioteca;

import producao.biblioteca.TipoBiblioteca;
import producao.visao.biblioteca.TipoVisaoBiblioteca;

public class ControleBiblioteca implements TipoControleBiblioteca {

	private TipoBiblioteca biblioteca;
	private TipoVisaoBiblioteca visao;

	public ControleBiblioteca(TipoBiblioteca biblioteca,
			TipoVisaoBiblioteca visaoBiblioteca) {
		this.biblioteca = biblioteca;
		this.visao = visaoBiblioteca;
	}

}

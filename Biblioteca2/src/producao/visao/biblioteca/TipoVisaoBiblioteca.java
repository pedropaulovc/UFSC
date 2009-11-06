package producao.visao.biblioteca;

import java.util.Observer;

import producao.formulario.visao.TipoFormularioBiblioteca;

public interface TipoVisaoBiblioteca extends Observer {
	public TipoFormularioBiblioteca obterFormulario();
}

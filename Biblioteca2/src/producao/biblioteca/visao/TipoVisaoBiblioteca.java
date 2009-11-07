package producao.biblioteca.visao;

import java.util.Observer;

import producao.formulario.visao.TipoFormularioBiblioteca;

public interface TipoVisaoBiblioteca extends Observer {
	public TipoFormularioBiblioteca obterFormulario();
}

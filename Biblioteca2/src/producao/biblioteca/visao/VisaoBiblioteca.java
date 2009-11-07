package producao.biblioteca.visao;

import java.util.Observable;
import java.util.Observer;

import producao.biblioteca.estatistica.VisaoEstatisticas;
import producao.biblioteca.estatistica.TipoVisaoEstatisticas;
import producao.biblioteca.modelo.TipoBiblioteca;
import producao.dados.nome.visao.VisaoNome;
import producao.formulario.visao.FormularioBiblioteca;
import producao.formulario.visao.TipoFormularioBiblioteca;
import edugraf.jadix.fachada.PaginaDix;

public class VisaoBiblioteca implements TipoVisaoBiblioteca, Observer {
	private TipoVisaoEstatisticas estatisticas;
	private TipoFormularioBiblioteca formulario;
	private TipoBiblioteca b;

	public VisaoBiblioteca(PaginaDix pagina, TipoBiblioteca biblioteca) {
		this.b = biblioteca;
		new VisaoNome(b.obterNome(), pagina);
		estatisticas = new VisaoEstatisticas(pagina);
		formulario = new FormularioBiblioteca(pagina);
	}

	public void update(Observable arg0, Object arg1) {
		estatisticas.exibir("Tamanho do acervo: " + b.tamanho());
	}
	
	public TipoFormularioBiblioteca obterFormulario(){
		return formulario;
	}

}
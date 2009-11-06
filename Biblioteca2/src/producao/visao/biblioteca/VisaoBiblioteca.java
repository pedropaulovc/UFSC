package producao.visao.biblioteca;

import java.util.Observable;
import java.util.Observer;

import producao.biblioteca.TipoBiblioteca;
import producao.dados.nome.visao.VisaoNome;
import edugraf.jadix.fachada.PaginaDix;

public class VisaoBiblioteca implements TipoVisaoBiblioteca, Observer {
	private Estatisticas estatisticas;
	private FormularioBiblioteca formulario;
	private Acervo acervo;
	private TipoBiblioteca b;

	public VisaoBiblioteca(PaginaDix pagina, TipoBiblioteca biblioteca) {
		this.b = biblioteca;
		new VisaoNome(b.obterNome(), pagina);
		/*formulario = new FormularioBiblioteca(pagina);
		estatisticas = new Estatisticas(pagina);
		acervo = new Acervo(pagina);*/
	}

	public void update(Observable arg0, Object arg1) {
		
	}

}
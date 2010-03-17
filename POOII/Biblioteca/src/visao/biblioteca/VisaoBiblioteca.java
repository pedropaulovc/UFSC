package visao.biblioteca;

import modelo.biblioteca.Documento;
import modelo.biblioteca.ListaDe;
import visao.biblioteca.acervo.Acervo;
import visao.biblioteca.estatisticas.Estatisticas;
import visao.biblioteca.formulario.FormularioBiblioteca;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class VisaoBiblioteca {
	private Estatisticas estatisticas;
	private FormularioBiblioteca formulario;
	private Acervo acervo;

	public VisaoBiblioteca(PaginaDix pagina) {
		new TituloPagina(pagina);
		formulario = new FormularioBiblioteca(pagina);
		estatisticas = new Estatisticas(pagina);
		acervo = new Acervo(pagina);
	}

	public void atualizarEstatisticas(String texto) {
		estatisticas.exibirEstatisticas(texto);
	}

	public void adicionarTratadorEnvioDados(TratadorDixAbstrato tratador) {
		formulario.adicionarTratadorEnvioDados(tratador);
	}
	
	public FormularioBiblioteca obterFormulario() {
		return formulario;
	}

	public void atualizarAcervo(ListaDe<Documento> acervoBiblioteca) {
		acervo.atualizar(acervoBiblioteca);
	}

}
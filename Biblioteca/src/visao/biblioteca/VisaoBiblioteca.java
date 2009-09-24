package visao.biblioteca;

import visao.biblioteca.formulario.FormularioBiblioteca;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class VisaoBiblioteca {
	private Estatisticas estatisticas;
	private FormularioBiblioteca formulario;

	public VisaoBiblioteca(PaginaDix pagina) {
		new TituloPagina(pagina);
		formulario = new FormularioBiblioteca(pagina);
		estatisticas = new Estatisticas(pagina);
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

	public void adicionarTratadorTipoDocumento(TratadorDixAbstrato tratador) {
		formulario.adicionarTratadorTipoDocumento(tratador);
	}

}
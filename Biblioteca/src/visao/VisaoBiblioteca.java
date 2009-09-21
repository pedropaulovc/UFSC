package visao;

import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class VisaoBiblioteca {
	private FormularioBiblioteca formulario;
	private Estatisticas estatisticas;

	public VisaoBiblioteca(PaginaDix pagina) {
		new Titulo(pagina);
		formulario = new FormularioBiblioteca(pagina);
		estatisticas = new Estatisticas(pagina);
	}
	
	public void atualizarEstatisticas (String texto){
		estatisticas.exibirEstatisticas(texto);
	}
	
	public void adicionarTratadorEstatisticas(TratadorDixAbstrato tratador){
		estatisticas.adicionarTratadorEventos(tratador);
	}
}
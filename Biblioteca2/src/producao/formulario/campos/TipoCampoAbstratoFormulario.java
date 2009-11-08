package producao.formulario.campos;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public interface TipoCampoAbstratoFormulario {
	public abstract ComponenteDix criarCampo(PaginaDix pagina);

	public String obterTexto();

	public void tornarVisivel();

	public void tornarInvisivel();

	public void adicionarTratadorEventos(TratadorDixAbstrato tratador);
}

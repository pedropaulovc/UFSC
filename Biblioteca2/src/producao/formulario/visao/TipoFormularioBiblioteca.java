package producao.formulario.visao;

import edugraf.jadix.fachada.TratadorDixAbstrato;

public interface TipoFormularioBiblioteca {
	public void adicionarTratadorEnvioDados(TratadorDixAbstrato tratador);

	public TipoCamposFormulario obterCamposFormulario();
}

package producao.biblioteca.visao;

import java.util.Observer;

import producao.biblioteca.controle.TratadorEnvioDados;
import producao.formulario.campos.TipoCamposFormulario;

public interface TipoVisaoBiblioteca extends Observer {
	public TipoCamposFormulario obterCamposFormulario();

	public void adicionarTratadorEnvioDados(
			TratadorEnvioDados tratadorEnvioDados);
}

package controle.biblioteca;

import visao.biblioteca.VisaoBiblioteca;
import visao.biblioteca.formulario.FormularioBiblioteca;
import edugraf.jadix.eventos.EventoDeSelecao;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorTipoDocumento extends TratadorDixAbstrato {
	private FormularioBiblioteca formulario;

	public TratadorTipoDocumento(FormularioBiblioteca formulario) {
		this.formulario = formulario;
	}

	//TODO: Fatorar esse código fedorento...
	//Provavelmente criar um polimorfismo de formulários com diferentes tratadores...
	public void seDito(EventoDeSelecao evento){
		String textoDaOpcao = evento.obterTextoDaOpcao();
		formulario.tornarInvisiveisCamposOpcionais();
		if(textoDaOpcao.equals("Livro")){
			formulario.tornarVisiveisCamposOpcionaisDeLivro();
		} else if (textoDaOpcao.equals("Dissertação")){
			formulario.tornarVisiveisCamposOpcionaisDeDissertacao();
		} else if (textoDaOpcao.equals("Tese")){
			formulario.tornarVisiveisCamposOpcionaisDeTese();
		} else if (textoDaOpcao.equals("TCC")){
			formulario.tornarVisiveisCamposOpcionaisDeTCC();
		}
	}
}

package aplique.selecaoSistemas;

import static edugraf.jadix.eventos.nomes.NomeDeEventosSimples.CLICADO;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorSelecaoSistemas extends TratadorDixAbstrato {
	private VisaoSelecaoSistemas sel;

	public TratadorSelecaoSistemas(VisaoSelecaoSistemas sel) {
		this.sel = sel;
	}

	public void seDito(EventoSimples evento) {
		if (evento.obterNomeDoEvento().equals(CLICADO)) {
			String selecao = sel.obterEscolha();
			if (selecao.equals("Biblioteca"))
				sel.criarBiblioteca();
			if (selecao.equals("Videoteca"))
				sel.criarVideoteca();
		}
	}
}

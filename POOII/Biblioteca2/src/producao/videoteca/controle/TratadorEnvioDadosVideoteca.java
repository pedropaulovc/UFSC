package producao.videoteca.controle;

import static edugraf.jadix.eventos.nomes.NomeDeEventosSimples.CLICADO;
import producao.videoteca.modelo.Videoteca;
import producao.videoteca.visao.VisaoVideoteca;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorEnvioDadosVideoteca extends TratadorDixAbstrato {

	private Videoteca v;
	private AdaptadorFormularioVideoteca adaptador;

	public TratadorEnvioDadosVideoteca(Videoteca videoteca, VisaoVideoteca visao) {
		this.v = videoteca;
		this.adaptador = new AdaptadorFormularioVideoteca(visao);

		adaptador.addObserver(visao);
	}

	public void seDito(EventoSimples evento) {
		if (evento.obterNomeDoEvento().equals(CLICADO)) {
			if(adaptador.dadosDeArquivoPreenchidos()){
				v.adicionar(adaptador.adaptarVideo(), adaptador
						.adaptarDadosDeArquivo());
				return;
			}
			v.adicionar(adaptador.adaptarVideo());
		}
	}

}

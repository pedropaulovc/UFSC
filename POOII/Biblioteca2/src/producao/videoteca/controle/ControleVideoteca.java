package producao.videoteca.controle;

import producao.videoteca.modelo.Videoteca;
import producao.videoteca.visao.VisaoVideoteca;

public class ControleVideoteca {
	private Videoteca v;
	private VisaoVideoteca visao;

	public ControleVideoteca(Videoteca videoteca, VisaoVideoteca visao) {
		this.v = videoteca;
		this.visao = visao;

		adicionarTratadoresEventos();
	}

	private void adicionarTratadoresEventos() {
		visao.adicionarTratadorEnvioDados(new TratadorEnvioDadosVideoteca(v, visao));
	}
}

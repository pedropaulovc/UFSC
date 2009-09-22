package controle.DadosExemplo;

import modelo.dadosExemplo.DadosExemplo;
import visao.dadosExemplo.VisaoDadosExemplo;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.eventos.nomes.NomeDeEventosSimples;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorDadosExemplo extends TratadorDixAbstrato {
	private DadosExemplo modelo;
	private VisaoDadosExemplo visao;

	public TratadorDadosExemplo(DadosExemplo modelo, VisaoDadosExemplo visao) {
		this.modelo = modelo;
		this.visao = visao;
		adicionarTratadorEventos();
	}

	private void adicionarTratadorEventos() {
		visao.adicionarTratador(this);
	}

	public void seDito(EventoSimples evento) {
		if (evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)) {
			modelo.popularBiblioteca();
		}
	}
}

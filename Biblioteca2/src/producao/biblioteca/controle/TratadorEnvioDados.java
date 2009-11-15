package producao.biblioteca.controle;

import producao.biblioteca.modelo.TipoBiblioteca;
import producao.biblioteca.visao.TipoVisaoBiblioteca;
import producao.formulario.AdaptadorFormulario;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.eventos.nomes.NomeDeEventosSimples;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorEnvioDados extends TratadorDixAbstrato {

	private AdaptadorFormulario adaptador;
	private TipoBiblioteca biblioteca;

	public TratadorEnvioDados(TipoBiblioteca biblioteca,
			TipoVisaoBiblioteca visao) {
		this.adaptador = new AdaptadorFormulario(visao);
		this.biblioteca = biblioteca;
	}

	public void seDito(EventoSimples evento) {
		if (evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)) {
			biblioteca.adicionar(adaptador.adaptarLivro(), adaptador
					.adaptarDadosDeArquivo());
		}
	}
}

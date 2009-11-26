package producao.biblioteca.controle;

import producao.biblioteca.modelo.Biblioteca;
import producao.biblioteca.visao.VisaoBiblioteca;
import producao.formulario.AdaptadorFormularioBiblioteca;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.eventos.nomes.NomeDeEventosSimples;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorEnvioDados extends TratadorDixAbstrato {

	private AdaptadorFormularioBiblioteca adaptador;
	private Biblioteca biblioteca;

	public TratadorEnvioDados(Biblioteca biblioteca, VisaoBiblioteca visao) {
		this.adaptador = new AdaptadorFormularioBiblioteca(visao);
		this.biblioteca = biblioteca;

		adaptador.addObserver(visao);
	}

	public void seDito(EventoSimples evento) {
		if (evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)) {
			biblioteca.adicionar(adaptador.adaptarLivro(), adaptador
					.adaptarDadosDeArquivo());
		}
	}
}

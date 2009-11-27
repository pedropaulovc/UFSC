package producao.biblioteca.controle;

import producao.biblioteca.modelo.Biblioteca;
import producao.biblioteca.visao.VisaoBiblioteca;
import edugraf.jadix.eventos.EventoSimples;
import static edugraf.jadix.eventos.nomes.NomeDeEventosSimples.CLICADO;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorEnvioDadosBiblioteca extends TratadorDixAbstrato {

	private AdaptadorFormularioBiblioteca adaptador;
	private Biblioteca biblioteca;

	public TratadorEnvioDadosBiblioteca(Biblioteca biblioteca, VisaoBiblioteca visao) {
		this.adaptador = new AdaptadorFormularioBiblioteca(visao);
		this.biblioteca = biblioteca;

		adaptador.addObserver(visao);
	}

	public void seDito(EventoSimples evento) {
		if (evento.obterNomeDoEvento().equals(CLICADO)) {
			if(adaptador.dadosDeArquivoPreenchidos()){
				biblioteca.adicionar(adaptador.adaptarLivro(), adaptador
						.adaptarDadosDeArquivo());
				return;
			}
			biblioteca.adicionar(adaptador.adaptarLivro());
		}
	}
}

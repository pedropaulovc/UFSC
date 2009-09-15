package controle;

import java.util.ArrayList;
import biblioteca.Biblioteca;
import biblioteca.Exemplar;
import biblioteca.Livro;
import biblioteca.NumeroChamada;
import biblioteca.TipoSituacao;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.eventos.nomes.NomeDeEventosSimples;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorBotaoDadosPadrao extends TratadorDixAbstrato {
	private Biblioteca biblioteca;
	public TratadorBotaoDadosPadrao(Biblioteca biblioteca, PaginaDix pagina) {
		this.biblioteca = biblioteca;
	}

	@Override
	public void seDito(EventoSimples evento) {
		if (evento.obterNomeDoEvento().equals(NomeDeEventosSimples.CLICADO)) {
			ArrayList<Exemplar> exemplar = new ArrayList<Exemplar>();
			exemplar.add(new Exemplar(1, TipoSituacao.DISPONIVEL));

			biblioteca.adicionarDocumento(new Livro("Titulo 1", 2000,
					"Autor 1", "Estante 3, prateleira 2",
					new NumeroChamada("325.223(22)"), exemplar, 10));
			biblioteca.adicionarDocumento(new Livro("Titulo 2", 2000,
					"Autor 2", "Estante 5, prateleira 7",
					new NumeroChamada("325.233(52)3(22)"), exemplar, 8));
			biblioteca.adicionarDocumento(new Livro("Titulo 1", 2000,
					"Autor 3", "Estante 1, prateleira 6",
					new NumeroChamada("325.235(22)"), exemplar, 6));
			
			for(int i = 0; i < biblioteca.qtdDocumentos(); i++){
				
			}
		}
	}
}
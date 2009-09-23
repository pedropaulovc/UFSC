package visao.biblioteca.formulario;

import java.util.ArrayList;
import java.util.List;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class ListaEscolhaSituacao extends CampoAbstratoFormulario {
	public ListaEscolhaSituacao(PaginaDix pagina) {
		super(pagina);		
	}

	@Override
	public ComponenteDix criarCampo(PaginaDix pagina) {
		criarListaSituacoes();		

		ComponenteDix componente = pagina.criarComponente(
				TiposDeComponentesDix.LISTA_DE_ESCOLHA, "situacao");
		componente.fixarTopo(320).fixarEsquerda(20).fixarLargura(150)
				.fixarLegenda("Situação");
		componente.fixarLista(criarListaSituacoes());
		return componente;
	}

	private List<String> criarListaSituacoes() {
		List<String> listaSituacoes = new ArrayList<String>();
		
		listaSituacoes.add("Consulta Local");
		listaSituacoes.add("Disponível");
		listaSituacoes.add("Em Restauração");
		listaSituacoes.add("Emprestado");
		
		return listaSituacoes;
	}
	
}

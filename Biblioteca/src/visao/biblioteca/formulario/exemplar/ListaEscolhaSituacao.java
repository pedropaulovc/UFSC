package visao.biblioteca.formulario.exemplar;

import java.util.ArrayList;
import java.util.List;

import modelo.biblioteca.estadosEmprestimo.Situacao;
import visao.biblioteca.formulario.CampoAbstratoFormulario;
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
		
		for(Situacao situacao : Situacao.values()){
			listaSituacoes.add(situacao.toString());
		}
		
		return listaSituacoes;
	}
	
}

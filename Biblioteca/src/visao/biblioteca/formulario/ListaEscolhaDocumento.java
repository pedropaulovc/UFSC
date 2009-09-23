package visao.biblioteca.formulario;

import java.util.ArrayList;
import java.util.List;

import controle.biblioteca.TratadorTipoDocumento;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class ListaEscolhaDocumento extends CampoAbstratoFormulario {

	public ListaEscolhaDocumento(PaginaDix pagina) {
		super(pagina);
	}

	@Override
	public ComponenteDix criarCampo(PaginaDix pagina) {
		ComponenteDix componente = pagina.criarComponente(
				TiposDeComponentesDix.LISTA_DE_ESCOLHA, "tipoDocumento");
		componente.fixarTopo(320).fixarEsquerda(200).fixarLargura(150)
				.fixarLegenda("Tipo de Documento");
		componente.fixarLista(criarListaDocumentos());
		return componente;
	}

	private List<String> criarListaDocumentos() {
		List<String> listaDocumentos = new ArrayList<String>();

		listaDocumentos.add("Livro");
		listaDocumentos.add("Revista");
		listaDocumentos.add("TCC");
		listaDocumentos.add("Tese");
		listaDocumentos.add("Dissertação");

		return listaDocumentos;
	}

}

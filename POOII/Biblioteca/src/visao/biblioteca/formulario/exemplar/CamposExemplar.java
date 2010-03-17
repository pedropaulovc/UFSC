package visao.biblioteca.formulario.exemplar;

import edugraf.jadix.fachada.PaginaDix;

public class CamposExemplar {
	private PaginaDix pagina;
	private ListaEscolhaSituacao listaEscolhaSituacao;
	private Localizacao localizacao;


	public CamposExemplar(PaginaDix pagina){
		this.pagina = pagina;
		criarCampos();
	}

	private void criarCampos() {
		listaEscolhaSituacao = new ListaEscolhaSituacao(pagina); 
		localizacao = new Localizacao(pagina);
	}
	
	public String obterSituacao(){
		return listaEscolhaSituacao.obterTexto();
	}
	
	public String obterLocalizacao(){
		return localizacao.obterTexto();
	}
}

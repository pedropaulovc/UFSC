package visao.biblioteca.formulario.documento;

import edugraf.jadix.fachada.PaginaDix;

public class CamposDocumento {
	private PaginaDix pagina;
	private Titulo titulo;
	private Autor autor;
	private ListaEscolhaDocumento listaEscolhaDocumento;

	public CamposDocumento(PaginaDix pagina){
		this.pagina = pagina;
		criarCampos();
	}

	private void criarCampos() {
		titulo =  new Titulo(pagina); 
		autor = new Autor(pagina);
		listaEscolhaDocumento = new ListaEscolhaDocumento(pagina);
	}
	
	public String obterTitulo(){
		return titulo.obterTexto();
	}
	
	public String obterAutor(){
		return autor.obterTexto();
	}
	
	public String obterTipoDocumento(){
		return listaEscolhaDocumento.obterTexto();
	}
}

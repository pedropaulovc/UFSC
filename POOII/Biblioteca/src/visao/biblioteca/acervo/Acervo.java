package visao.biblioteca.acervo;

import modelo.biblioteca.Documento;
import modelo.biblioteca.ListaDe;
import edugraf.jadix.fachada.PaginaDix;

public class Acervo {
	private PaginaDix pagina;

	public Acervo(PaginaDix pagina) {
		this.pagina = pagina;
	}
	
	public void atualizar(ListaDe<Documento> acervoBiblioteca) {
		for(int i = 0; i < acervoBiblioteca.tamanho(); i++){
			Documento documento = acervoBiblioteca.obter(i);
			int numeroDocumento = i;
			new VisaoDocumento(documento, numeroDocumento, pagina);
		}
	}
}

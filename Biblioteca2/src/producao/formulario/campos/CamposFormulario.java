package producao.formulario.campos;

import producao.dados.autor.visao.TipoVisaoAutor;
import producao.dados.autor.visao.VisaoAutor;
import producao.dados.titulo.visao.TipoVisaoTitulo;
import producao.dados.titulo.visao.VisaoTitulo;
import edugraf.jadix.fachada.PaginaDix;

public class CamposFormulario implements TipoCamposFormulario {

	private PaginaDix pagina;
	private TipoVisaoTitulo titulo;
	private TipoVisaoAutor autor;

	public CamposFormulario(PaginaDix pagina) {
		this.pagina = pagina;
		criarCampos();
	}

	private void criarCampos() {
		titulo = new VisaoTitulo(pagina);
		autor = new VisaoAutor(pagina);
	}

	public String obterTitulo() {
		return titulo.obterTexto();
	}

	public String obterAutor() {
		return autor.obterTexto();
	}

}

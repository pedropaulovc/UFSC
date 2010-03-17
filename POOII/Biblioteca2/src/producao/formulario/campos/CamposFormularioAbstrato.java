package producao.formulario.campos;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import edugraf.jadix.fachada.PaginaDix;

public abstract class CamposFormularioAbstrato {
	private PaginaDix pagina;
	private CampoFormulario titulo;
	private CampoFormulario anoPublicacao;

	public CamposFormularioAbstrato(PaginaDix pagina) {
		this.pagina = pagina;
		criarCampos();
	}

	private void criarCampos() {
		titulo = new CampoFormulario(pagina, new Rectangle(new Point(120, 20),
				new Dimension(500, 0)), "Título");

		anoPublicacao = new CampoFormulario(pagina, new Rectangle(new Point(
				270, 400), new Dimension(100, 0)), "Ano de Publicação");
	}

	public String obterTitulo() {
		return titulo.obterTexto();
	}

	public String obterAnoPublicacao() {
		return anoPublicacao.obterTexto();
	}
}

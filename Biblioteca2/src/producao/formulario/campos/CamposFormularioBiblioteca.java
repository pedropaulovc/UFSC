package producao.formulario.campos;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import edugraf.jadix.fachada.PaginaDix;

public class CamposFormularioBiblioteca extends CamposFormularioAbstrato {

	private PaginaDix pagina;
	private CampoFormulario autor, numeroChamada,
			nomeEditora;

	public CamposFormularioBiblioteca(PaginaDix pagina) {
		super(pagina);
		this.pagina = pagina;
		criarCamposBiblioteca();
	}

	private void criarCamposBiblioteca() {
		autor = new CampoFormulario(pagina, new Rectangle(new Point(170, 20),
				new Dimension(500, 0)), "Autor");

		nomeEditora = new CampoFormulario(pagina, new Rectangle(new Point(220,
				20), new Dimension(500, 0)), "Nome da Editora");

		numeroChamada = new CampoFormulario(pagina, new Rectangle(new Point(
				270, 20), new Dimension(100, 0)), "Número de Chamada");
	}

	public String obterAutor() {
		return autor.obterTexto();
	}

	public String obterNumeroChamada() {
		return numeroChamada.obterTexto();
	}

	public String obterNomeEditora() {
		return nomeEditora.obterTexto();
	}
}

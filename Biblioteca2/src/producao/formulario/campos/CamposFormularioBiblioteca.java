package producao.formulario.campos;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import edugraf.jadix.fachada.PaginaDix;

public class CamposFormularioBiblioteca {

	private PaginaDix pagina;
	private CampoFormulario titulo, autor, anoPublicacao, numeroChamada,
			nomeEditora;

	public CamposFormularioBiblioteca(PaginaDix pagina) {
		this.pagina = pagina;
		criarCampos();
	}

	private void criarCampos() {
		titulo = new CampoFormulario(pagina, new Rectangle(new Point(120, 20),
				new Dimension(500, 0)), "Título");

		autor = new CampoFormulario(pagina, new Rectangle(new Point(170, 20),
				new Dimension(500, 0)), "Autor");

		nomeEditora = new CampoFormulario(pagina, new Rectangle(new Point(220,
				20), new Dimension(500, 0)), "Nome da Editora");

		anoPublicacao = new CampoFormulario(pagina, new Rectangle(new Point(
				270, 280), new Dimension(100, 0)), "Ano de Publicação");

		numeroChamada = new CampoFormulario(pagina, new Rectangle(new Point(
				270, 20), new Dimension(100, 0)), "Número de Chamada");
	}

	public String obterTitulo() {
		return titulo.obterTexto();
	}

	public String obterAutor() {
		return autor.obterTexto();
	}

	public String obterAnoPublicacao() {
		return anoPublicacao.obterTexto();
	}

	public String obterNumeroChamada() {
		return numeroChamada.obterTexto();
	}

	public String obterNomeEditora() {
		return nomeEditora.obterTexto();
	}
}

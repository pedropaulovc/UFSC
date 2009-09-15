package biblioteca;

import java.util.List;

public class Livro extends Documento {
	private int qtdCapitulos;

	public Livro(String titulo, int anoPublicacao, String autor,
			String localizacao, NumeroChamada numeroChamada,
			List<Exemplar> exemplares, int qtdCapitulos) {
		super(titulo, anoPublicacao, autor, localizacao, numeroChamada,
				exemplares);
		this.qtdCapitulos = qtdCapitulos;
	}

	public void alterarQtdCapitulos(int qtdCapitulos) {
		this.qtdCapitulos = qtdCapitulos;
	}

	public int obterQtdCapitulos() {
		return qtdCapitulos;
	}
}

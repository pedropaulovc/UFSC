package producao.livro;

import java.util.ArrayList;
import java.util.List;

public class Livro implements TipoLivro {
	private TipoDadosLivro dados;
	private List<TipoExemplar> listaExemplares;

	public Livro(TipoDadosLivro dados) {
		this.dados = dados;
		this.listaExemplares = new ArrayList<TipoExemplar>();
	}

	public TipoAutor obterAutor() {
		return dados.obterAutor();
	}

	public TipoTitulo obterTitulo() {
		return dados.obterTitulo();
	}

	public int qtdExemplares() {
		return listaExemplares.size();
	}

	public boolean adicionarExemplar(TipoDadosExemplar dadosExemplar) {
		return listaExemplares.add(new Exemplar(dadosExemplar));
	}

	public TipoExemplar obterExemplar(int i) {
		return listaExemplares.get(i - 1);
	}

	@Override
	public TipoExemplar removerExemplar(int i) {
		return listaExemplares.remove(i - 1);
	}
}

package producao.livro;

import java.util.ArrayList;
import java.util.List;

public class Livro implements TipoLivro {
	private TipoDadosLivro dados;
	private List<TipoEdicao> listaEdicoes;

	public Livro(TipoDadosLivro dados) {
		this.dados = dados;
		this.listaEdicoes = new ArrayList<TipoEdicao>();
	}

	public TipoAutor obterAutor() {
		return dados.obterAutor();
	}

	public TipoTitulo obterTitulo() {
		return dados.obterTitulo();
	}

	public boolean adicionarEdicao(TipoEdicao edicao) {
		return listaEdicoes.add(edicao);
	}

	public TipoEdicao obterEdicao(int edicao) {
		assert (edicao > 0);
		return listaEdicoes.get(edicao - 1);
	}

	public TipoEdicao removerEdicao(int edicao) {
		assert (edicao > 0);
		return listaEdicoes.remove(edicao - 1);
	}

	public int qtdEdicoes() {
		return listaEdicoes.size();
	}

}

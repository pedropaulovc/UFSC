package producao.dados.listaAtores;

import java.util.List;

import producao.dados.nome.modelo.TipoNome;

public class ListaAtores implements TipoListaAtores {

	private List<TipoNome> atores;

	public ListaAtores(List<TipoNome> atores) {
		this.atores = atores;
	}

	public TipoNome obterAtor(int i) {
		return atores.get(i);
	}

	public int qtdAtores() {
		return atores.size();
	}

}

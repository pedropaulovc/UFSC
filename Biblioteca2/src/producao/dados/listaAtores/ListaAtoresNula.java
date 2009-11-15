package producao.dados.listaAtores;

import producao.dados.nome.modelo.NomeNulo;
import producao.dados.nome.modelo.TipoNome;

public class ListaAtoresNula implements TipoListaAtores {

	public TipoNome obterAtor(int i) {
		return new NomeNulo();
	}

	public int qtdAtores() {
		return 0;
	}

}

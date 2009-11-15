package producao.dados.listaAtores;

import producao.dados.nome.modelo.TipoNome;

public interface TipoListaAtores {
	public TipoNome obterAtor(int i);

	public int qtdAtores();
}

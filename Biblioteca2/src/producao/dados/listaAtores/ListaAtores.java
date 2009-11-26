package producao.dados.listaAtores;

import static producao.dados.listaAtores.ValidadorListaAtores.validarListaNaoVazia;

import java.util.List;

import producao.dados.ExcecaoParametroInvalido;
import producao.dados.nome.modelo.TipoNome;

public class ListaAtores implements TipoListaAtores {

	private List<TipoNome> atores;

	public ListaAtores(List<TipoNome> atores) throws ExcecaoParametroInvalido {
		assert atores != null;
		assert atores.size() != 0;

		if (!validarListaNaoVazia(atores))
			throw new ExcecaoParametroInvalido("Lista de atores vazia");
		this.atores = atores;
	}

	public TipoNome obterAtor(int i) {
		return atores.get(i);
	}

	public int qtdAtores() {
		return atores.size();
	}

}

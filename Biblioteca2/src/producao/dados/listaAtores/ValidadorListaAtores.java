package producao.dados.listaAtores;

import java.security.InvalidParameterException;
import java.util.List;

import producao.dados.nome.modelo.TipoNome;

public class ValidadorListaAtores {
	public static boolean validarListaNaoVazia(List<TipoNome> atores) {
		if (atores == null || atores.size() == 0)
			throw new InvalidParameterException("Lista de atores vazia");
		return true;
	}
}

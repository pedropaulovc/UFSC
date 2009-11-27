package producao.dados.nome.modelo;

import static producao.dados.ValidadorString.validarStringNaoVazia;
import producao.dados.ExcecaoParametroInvalido;

public class Nome implements TipoNome {
	private String nome;

	public Nome(String nome) throws ExcecaoParametroInvalido {
		assert nome.length() != 0;
		if (!validarStringNaoVazia(nome))
			throw new ExcecaoParametroInvalido("Campo nome vazio");
		this.nome = nome;
	}

	public String toString() {
		return nome;
	}

	public static boolean validar(String nome) {
		return validarStringNaoVazia(nome);
	}
}

package producao.dados.autor.modelo;

import static producao.dados.ValidadorString.validarStringNaoVazia;
import producao.dados.ExcecaoParametroInvalido;

public class Autor implements TipoAutor {

	private String autor;

	public Autor(String autor) throws ExcecaoParametroInvalido {
		assert autor.length() != 0;
		if (!validarStringNaoVazia(autor))
			throw new ExcecaoParametroInvalido("Nome autor vazio");
		this.autor = autor;
	}

	public String toString() {
		return autor;
	}

}

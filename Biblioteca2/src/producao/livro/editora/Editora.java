package producao.livro.editora;

import producao.dados.ExcecaoParametroInvalido;
import producao.livro.Livro;
import producao.livro.TipoLivro;
import producao.livro.dados.DadosLivro;

public class Editora {

	public TipoLivro criarLivro(DadosLivro dados) {
		if(dados == null)
			throw new ExcecaoParametroInvalido("Parâmetros inválidos");
		return new Livro(dados);
	}
}

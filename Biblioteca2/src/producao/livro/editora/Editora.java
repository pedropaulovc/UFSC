package producao.livro.editora;

import producao.livro.Livro;
import producao.livro.TipoLivro;
import producao.livro.dados.TipoDadosLivro;

public class Editora {

	public TipoLivro criarLivro(TipoDadosLivro dados) {
		return new Livro(dados);
	}
}

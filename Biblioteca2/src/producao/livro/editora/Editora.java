package producao.livro.editora;

import producao.livro.Livro;
import producao.livro.TipoLivro;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.exemplar.LivroComExemplares;
import producao.livro.exemplar.TipoLivroComExemplaresNaoArquivaveis;

public class Editora implements TipoEditora {

	public TipoLivro criarLivro(TipoDadosLivro dados) {
		return new Livro(dados);
	}

	public TipoLivroComExemplaresNaoArquivaveis criarLivroComExemplares(
			TipoDadosLivro dados) {
		return new LivroComExemplares(dados);
	}

}

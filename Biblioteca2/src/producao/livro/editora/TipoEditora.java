package producao.livro.editora;

import producao.livro.TipoLivro;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.exemplar.TipoLivroComExemplaresNaoArquivaveis;

public interface TipoEditora {
	public TipoLivro criarLivro(TipoDadosLivro dados);

	public TipoLivroComExemplaresNaoArquivaveis criarLivroComExemplares(
			TipoDadosLivro dados);
}

package producao.livro.editora;

import producao.livro.dados.TipoDadosLivro;
import producao.livro.exemplar.TipoLivroComExemplaresArquivaveis;

public interface TipoEditoraBiblioteca extends TipoEditora {
	public TipoLivroComExemplaresArquivaveis criarLivroComExemplaresArquivaveis(
			TipoDadosLivro dados);
}

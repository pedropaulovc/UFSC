package producao.livro.editora;

import producao.livro.dados.TipoDadosLivro;
import producao.livro.exemplar.LivroComExemplaresArquivaveis;
import producao.livro.exemplar.TipoLivroComExemplaresArquivaveis;

public class EditoraBiblioteca extends Editora implements TipoEditoraBiblioteca {

	public TipoLivroComExemplaresArquivaveis criarLivroComExemplaresArquivaveis(
			TipoDadosLivro dados) {
		return new LivroComExemplaresArquivaveis(dados);
	}
}

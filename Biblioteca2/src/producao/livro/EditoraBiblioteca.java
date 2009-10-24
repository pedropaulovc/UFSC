package producao.livro;

public class EditoraBiblioteca extends Editora implements TipoEditoraBiblioteca {

	public TipoLivroComExemplaresArquivaveis criarLivroComExemplaresArquivaveis(
			TipoDadosLivro dados) {
		return new LivroComExemplaresArquivaveis(dados);
	}
}

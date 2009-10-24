package producao.livro;

public interface TipoEditoraBiblioteca extends TipoEditora {
	public TipoLivroComExemplaresArquivaveis criarLivroComExemplaresArquivaveis(
			TipoDadosLivro dados);
}

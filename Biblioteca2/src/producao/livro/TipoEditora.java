package producao.livro;

public interface TipoEditora {
	public TipoLivro criarLivro(TipoDadosLivro dados);

	public TipoLivroComExemplaresNaoArquivaveis criarLivroComExemplares(
			TipoDadosLivro dados);
}

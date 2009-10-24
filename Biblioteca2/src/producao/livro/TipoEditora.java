package producao.livro;

public interface TipoEditora {
	public TipoLivro criarLivro(TipoDadosLivro dados);

	public TipoLivroComExemplares criarLivroComExemplares(TipoDadosLivro dados);
}

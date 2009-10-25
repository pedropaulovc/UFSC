package producao.livro;

public interface TipoLivroComExemplares extends TipoLivro {
	public int qtdExemplares();

	public void removerExemplar(TipoIdentificacao exemplar);

	public TipoAnoPublicacao obterAnoPublicacaoExemplar(
			TipoIdentificacao exemplar);

	public TipoNomeEditora obterNomeEditoraExemplar(TipoIdentificacao exemplar);

	public TipoDadosExemplar obterDadosExemplar(TipoIdentificacao exemplar);
}

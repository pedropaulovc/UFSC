package producao.livro;

public interface TipoLivroComExemplares extends TipoLivro {
	public int qtdExemplares();

	public void removerExemplar(TipoIdentificacaoExemplar exemplar);

	public TipoAnoPublicacao obterAnoPublicacaoExemplar(
			TipoIdentificacaoExemplar exemplar);

	public TipoNomeEditora obterNomeEditoraExemplar(TipoIdentificacaoExemplar exemplar);

	public TipoDadosExemplar obterDadosExemplar(TipoIdentificacaoExemplar exemplar);
	
	public boolean contemExemplar(TipoIdentificacaoExemplar exemplar);
}

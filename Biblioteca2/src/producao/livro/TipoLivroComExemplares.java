package producao.livro;

public interface TipoLivroComExemplares extends TipoLivro {
	public int qtdExemplares();

	public TipoExemplar removerExemplar(int i);
	
	public TipoAnoPublicacao obterAnoPublicacaoExemplar(int i);
	
	public TipoNomeEditora obterNomeEditoraExemplar(int i);
	
	public TipoDadosExemplar obterDadosExemplar(int i);
}

package producao.livro;

public interface TipoLivroComExemplaresArquivaveis extends
		TipoLivroComExemplares {
	public boolean adicionarExemplar(TipoDadosExemplarArquivavel dadosExemplar);

	public TipoExemplarArquivavel removerExemplar(int i);

	public TipoIdentificacao obterIdentificacaoExemplar(int i);

	public TipoNumeroChamada obterNumeroChamada(int i);
	
	public TipoDadosExemplarArquivavel obterDadosExemplar(int i);

}

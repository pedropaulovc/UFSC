package producao.livro;

public interface TipoLivroComExemplaresArquivaveis extends
		TipoLivroComExemplares {
	public boolean adicionarExemplar(TipoDadosExemplar dadosExemplar);

	public TipoExemplarArquivavel removerExemplar(int i);

	public TipoIdentificacao obterIdentificacaoExemplar(int i);

}

package producao.livro;

public interface TipoLivroComExemplaresArquivaveis extends
		TipoLivroComExemplares {
	public TipoIdentificacao adicionarExemplar(TipoDadosExemplarArquivavel dadosExemplar);

	public TipoNumeroChamada obterNumeroChamada(TipoIdentificacao exemplar);
	
	public TipoDadosExemplarArquivavel obterDadosExemplar(TipoIdentificacao exemplar);

}

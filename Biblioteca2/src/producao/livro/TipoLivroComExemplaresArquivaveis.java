package producao.livro;

public interface TipoLivroComExemplaresArquivaveis extends
		TipoLivroComExemplares {
	public void adicionarExemplar(TipoDadosExemplarArquivavel dadosExemplar);

	public TipoNumeroChamada obterNumeroChamada(TipoIdentificacao exemplar);
	
	public TipoDadosExemplarArquivavel obterDadosExemplar(TipoIdentificacao exemplar);

}

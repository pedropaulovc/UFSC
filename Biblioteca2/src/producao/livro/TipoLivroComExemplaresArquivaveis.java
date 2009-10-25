package producao.livro;

public interface TipoLivroComExemplaresArquivaveis extends
		TipoLivroComExemplares {
	public TipoIdentificacaoExemplar adicionarExemplar(TipoDadosExemplarArquivavel dadosExemplar);

	public TipoNumeroChamada obterNumeroChamada(TipoIdentificacaoExemplar exemplar);
	
	public TipoDadosExemplarArquivavel obterDadosExemplar(TipoIdentificacaoExemplar exemplar);
}

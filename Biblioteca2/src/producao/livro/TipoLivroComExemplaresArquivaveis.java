package producao.livro;


public interface TipoLivroComExemplaresArquivaveis extends
		TipoLivroComExemplares {
	public TipoIdentificacaoExemplar adicionarExemplar(
			TipoDadosExemplarArquivavel dadosExemplar);

	public TipoNumeroChamada obterNumeroChamada(
			TipoIdentificacaoExemplar exemplar);

	public TipoDadosExemplarArquivavel obterDadosExemplar(
			TipoIdentificacaoExemplar exemplar);

	public boolean emprestar(TipoIdentificacaoExemplar idExemplar, int prazo);

	public EstadoEmprestimo obterEstado(TipoIdentificacaoExemplar idExemplar);

	public TipoPrazoDevolucao obterPrazoDevolucao(
			TipoIdentificacaoExemplar idExemplar);

	public boolean devolver(TipoIdentificacaoExemplar idExemplar);
}

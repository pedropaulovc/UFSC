package producao.livro;


public interface TipoExemplarArquivavel extends TipoExemplar {
	public TipoNumeroChamada obterNumeroChamada();
	
	public TipoIdentificacaoExemplar obterIdentificacao();
	
	public TipoDadosExemplarArquivavel obterDados();

	public boolean emprestar(int prazo);

	public EstadoEmprestimo obterEstado();

	public TipoPrazoDevolucao obterPrazoDevolucao();

	public boolean devolver();
}

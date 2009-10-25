package producao.livro;

public interface TipoExemplarArquivavel extends TipoExemplar {
	public TipoNumeroChamada obterNumeroChamada();
	
	public TipoIdentificacaoExemplar obterIdentificacao();
	
	public TipoDadosExemplarArquivavel obterDados();
}

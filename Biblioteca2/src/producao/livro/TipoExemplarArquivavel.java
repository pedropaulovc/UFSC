package producao.livro;

public interface TipoExemplarArquivavel extends TipoExemplar {
	public TipoNumeroChamada obterNumeroChamada();
	
	public TipoIdentificacao obterIdentificacao();
	
	public TipoDadosExemplarArquivavel obterDados();
}

package producao.livro;

public class ExemplarArquivavel extends Exemplar implements TipoExemplarArquivavel {
	private TipoDadosExemplarArquivavel dados;

	public ExemplarArquivavel(TipoDadosExemplarArquivavel dados) {
		super(dados);
		this.dados = dados;
	}

	public TipoIdentificacao obterIdentificacao() {
		return dados.obterIdentificacao();
	}

	public TipoNumeroChamada obterNumeroChamada() {
		return dados.obterNumeroChamada();
	}
	
	public TipoDadosExemplarArquivavel obterDados(){
		return dados;
	}
}

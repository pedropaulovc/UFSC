package producao.livro;


public class LivroArquivavel extends Livro implements TipoLivroArquivavel {

	private TipoDadosArquivoLivro dadosArquivo;

	public LivroArquivavel(TipoDadosLivro dados,
			TipoDadosArquivoLivro dadosArquivo) {
		super(dados);
		this.dadosArquivo = dadosArquivo;
	}

	public TipoNumeroChamada obterNumeroChamada() {
		return dadosArquivo.obterNumeroChamada();
	}

}

package producao.livro;


public class DadosArquivoLivro implements TipoDadosArquivoLivro {

	private TipoNumeroChamada numeroChamada;

	public DadosArquivoLivro(String dados) {
		assert (dados != null);
		String[] dadosSeparados = dados.split(";");
		
		this.numeroChamada = new NumeroChamada(dadosSeparados[0]);
	}

	@Override
	public TipoNumeroChamada obterNumeroChamada() {
		return numeroChamada;
	}

}

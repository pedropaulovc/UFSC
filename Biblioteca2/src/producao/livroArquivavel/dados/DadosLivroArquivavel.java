package producao.livroArquivavel.dados;

import producao.dados.numeroChamada.TipoNumeroChamada;

public class DadosLivroArquivavel implements TipoDadosLivroArquivavel {

	private TipoNumeroChamada numeroChamada;

	public DadosLivroArquivavel(TipoNumeroChamada numeroChamada) {
		this.numeroChamada = numeroChamada;
	}

	public TipoNumeroChamada obterNumeroChamada() {
		return numeroChamada;
	}

}

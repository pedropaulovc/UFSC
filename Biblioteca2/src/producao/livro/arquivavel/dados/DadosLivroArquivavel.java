package producao.livro.arquivavel.dados;

import producao.dados.numeroChamada.modelo.TipoNumeroChamada;

public class DadosLivroArquivavel implements TipoDadosLivroArquivavel {

	private TipoNumeroChamada numeroChamada;

	public DadosLivroArquivavel(TipoNumeroChamada numeroChamada) {
		this.numeroChamada = numeroChamada;
	}

	public TipoNumeroChamada obterNumeroChamada() {
		return numeroChamada;
	}

}

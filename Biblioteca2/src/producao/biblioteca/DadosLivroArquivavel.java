package producao.biblioteca;

import producao.livro.TipoDadosLivroArquivavel;
import producao.livro.exemplar.numeroChamada.TipoNumeroChamada;

public class DadosLivroArquivavel implements TipoDadosLivroArquivavel {

	private TipoNumeroChamada numeroChamada;

	public DadosLivroArquivavel(TipoNumeroChamada numeroChamada) {
		this.numeroChamada = numeroChamada;
	}

	public TipoNumeroChamada obterNumeroChamada() {
		return numeroChamada;
	}

}

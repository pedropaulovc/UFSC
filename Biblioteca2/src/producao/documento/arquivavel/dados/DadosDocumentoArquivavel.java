package producao.documento.arquivavel.dados;

import producao.dados.numeroChamada.modelo.TipoNumeroChamada;

public class DadosDocumentoArquivavel implements TipoDadosDocumentoArquivavel {
	private TipoNumeroChamada numeroChamada;

	public DadosDocumentoArquivavel(TipoNumeroChamada numeroChamada) {
		this.numeroChamada = numeroChamada;
	}

	public TipoNumeroChamada obterNumeroChamada() {
		return numeroChamada;
	}
}

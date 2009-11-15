package producao.video.arquivavel.dados;

import producao.video.arquivavel.TipoLancamento;

public class DadosVideoArquivavel implements TipoDadosVideoArquivavel {

	private TipoLancamento tipoLancamento;

	public DadosVideoArquivavel(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public TipoLancamento obterTipoDeLancamento() {
		return tipoLancamento;
	}

}

package producao.video.arquivavel.dados;

import static producao.video.arquivavel.TipoLancamento.NULO;
import producao.video.arquivavel.TipoLancamento;

public class DadosVideoArquivavelNulo implements TipoDadosVideoArquivavel {

	public TipoLancamento obterTipoDeLancamento() {
		return NULO;
	}

}

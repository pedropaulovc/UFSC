package producao.video.arquivavel.dados;

import static producao.video.arquivavel.TipoLancamento.OUTRO;
import producao.video.arquivavel.TipoLancamento;

public class DadosVideoArquivavelNulo implements TipoDadosVideoArquivavel {

	public TipoLancamento obterTipoDeLancamento() {
		return OUTRO;
	}
	
	public String toSting(){
		return new String();
	}

}

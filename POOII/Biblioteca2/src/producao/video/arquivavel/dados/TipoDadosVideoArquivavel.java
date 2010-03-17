package producao.video.arquivavel.dados;

import producao.documento.arquivavel.dados.TipoDadosDocumentoArquivavel;
import producao.video.arquivavel.TipoLancamento;

public interface TipoDadosVideoArquivavel extends TipoDadosDocumentoArquivavel {
	public TipoLancamento obterTipoDeLancamento();
}

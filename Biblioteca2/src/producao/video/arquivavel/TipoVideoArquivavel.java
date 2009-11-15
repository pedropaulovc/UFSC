package producao.video.arquivavel;

import producao.documento.arquivavel.TipoDocumentoArquivavel;
import producao.video.TipoVideo;

public interface TipoVideoArquivavel extends TipoVideo, TipoDocumentoArquivavel {
	public TipoVideo obterDocumento();
}

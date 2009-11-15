package producao.videoteca;

import producao.dados.id.TipoId;
import producao.video.TipoVideo;
import producao.video.arquivavel.dados.TipoDadosVideoArquivavel;
import producao.xteca.TipoXteca;

public interface TipoVideoteca extends TipoXteca {

	public TipoId adicionar(TipoVideo video);

	public TipoVideo obter(TipoId idVideo);

	public TipoId adicionar(TipoVideo video, TipoDadosVideoArquivavel dados);

	public TipoDadosVideoArquivavel obterDadosDeArquivo(TipoId idVideo);

}

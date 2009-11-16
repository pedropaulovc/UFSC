package producao.videoteca.modelo;

import producao.dados.id.TipoId;
import producao.video.TipoVideo;
import producao.video.VideoNulo;
import producao.video.arquivavel.VideoArquivavel;
import producao.video.arquivavel.dados.TipoDadosVideoArquivavel;
import producao.videoteca.modelo.configuracao.TipoConfiguracaoVideoteca;
import producao.xteca.Xteca;

public class Videoteca extends Xteca implements TipoVideoteca {

	public Videoteca(TipoConfiguracaoVideoteca config) {
		super(config);
	}

	public TipoId adicionar(TipoVideo video) {
		return adicionarDocumento(new VideoArquivavel(video));
	}

	public TipoId adicionar(TipoVideo video, TipoDadosVideoArquivavel dados) {
		return adicionarDocumento(new VideoArquivavel(video, dados));
	}

	public TipoVideo obter(TipoId idVideo) {
		try {
			return (TipoVideo) obterDocumento(idVideo);
		} catch (ClassCastException e) {
			return new VideoNulo();
		}
	}

	public TipoDadosVideoArquivavel obterDadosDeArquivo(TipoId idLivro) {
		return (TipoDadosVideoArquivavel) super.obterDadosDeArquivo(idLivro);
	}
}

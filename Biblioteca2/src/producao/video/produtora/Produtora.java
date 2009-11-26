package producao.video.produtora;

import producao.video.TipoVideo;
import producao.video.Video;
import producao.video.dados.TipoDadosVideo;

public class Produtora {

	public TipoVideo criarVideo(TipoDadosVideo dados) {
		return new Video(dados);
	}

}

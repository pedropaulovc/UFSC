package producao.video.produtora;

import producao.video.Video;
import producao.video.dados.TipoDadosVideo;

public class Produtora {

	public Video criarVideo(TipoDadosVideo dados) {
		return new Video(dados);
	}

}

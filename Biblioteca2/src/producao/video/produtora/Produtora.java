package producao.video.produtora;

import producao.video.TipoVideo;
import producao.video.Video;
import producao.video.dados.TipoDadosVideo;

public class Produtora implements TipoProdutora {

	public TipoVideo criarVideo(TipoDadosVideo dados) {
		return new Video(dados);
	}

}

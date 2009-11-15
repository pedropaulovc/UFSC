package producao.video.produtora;

import producao.video.TipoVideo;
import producao.video.dados.TipoDadosVideo;

public interface TipoProdutora {

	public TipoVideo criarVideo(TipoDadosVideo dados);

}

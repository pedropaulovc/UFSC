package historia.videoteca;

import static org.junit.Assert.assertFalse;
import infra.CenarioComVideoteca;

import org.junit.Test;

import producao.dados.id.TipoId;
import producao.video.TipoVideo;
import producao.videoteca.modelo.TipoVideoteca;

public class VideosDiferentesPossuemIdsDiferentes extends CenarioComVideoteca {
	private TipoVideo video1, video2;
	private TipoVideoteca b;
	private TipoId idVideo1, idVideo2;

	public void dadoQue() {
		existeUmaVideoteca();
		existemDadosDeDoisVideos();
	}

	public void quando() {
		adicionarOsVideosNaVideoteca();
	}

	public void então() {
		osIdsDosVideosSerãoDiferentes();
	}

	private void existeUmaVideoteca() {
		b = obterVideoteca();
	}

	private void existemDadosDeDoisVideos() {
		video1 = obterVideo();
		video2 = obterVideo();
	}

	private void adicionarOsVideosNaVideoteca() {
		idVideo1 = b.adicionar(video1);
		idVideo2 = b.adicionar(video2);
	}

	@Test
	public void osIdsDosVideosSerãoDiferentes() {
		assertFalse(idVideo1.equals(idVideo2));
	}
}

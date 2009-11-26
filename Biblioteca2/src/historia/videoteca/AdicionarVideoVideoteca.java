package historia.videoteca;

import static org.junit.Assert.assertEquals;
import static producao.documento.arquivavel.EstadoEmprestimo.DISPONÍVEL;
import infra.CenarioComVideoteca;

import org.junit.Test;

import producao.dados.id.TipoId;
import producao.video.TipoVideo;
import producao.videoteca.modelo.Videoteca;

public class AdicionarVideoVideoteca extends CenarioComVideoteca {
	private Videoteca v;
	private TipoId idVideo;
	private TipoVideo video;

	public void dadoQue() {
		existeUmaVideotecaaComNenhumVideo();
		existeUmVideo();
	}

	public void quando() {
		adicionaVideoNaVideoteca();
	}

	public void então() {
		aVideotecaPossuiUmVideo();
		éPossívelObterOVideoArmazenado();
		oVideoFicaDisponível();
	}

	@Test
	public void existeUmaVideotecaaComNenhumVideo() {
		v = obterVideoteca();

		assertEquals(0, v.tamanho());
	}

	private void existeUmVideo() {
		video = obterVideo();
	}

	private void adicionaVideoNaVideoteca() {
		idVideo = v.adicionar(video);
	}

	@Test
	public void aVideotecaPossuiUmVideo() {
		assertEquals(1, v.tamanho());
	}

	@Test
	public void éPossívelObterOVideoArmazenado() {
		assertEquals(video, v.obter(idVideo));
	}

	@Test
	public void oVideoFicaDisponível() {
		assertEquals(DISPONÍVEL, v.obterEstadoDocumento(idVideo));
	}
}

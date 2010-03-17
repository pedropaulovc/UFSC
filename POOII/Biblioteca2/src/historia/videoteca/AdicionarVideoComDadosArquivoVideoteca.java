package historia.videoteca;

import static org.junit.Assert.assertEquals;
import static producao.documento.arquivavel.EstadoEmprestimo.DISPONÍVEL;
import static producao.video.arquivavel.TipoLancamento.CATÁLOGO;
import infra.CenarioComVideoteca;

import org.junit.Test;

import producao.dados.id.TipoId;
import producao.video.TipoVideo;
import producao.video.arquivavel.dados.DadosVideoArquivavel;
import producao.video.arquivavel.dados.TipoDadosVideoArquivavel;
import producao.videoteca.modelo.Videoteca;

public class AdicionarVideoComDadosArquivoVideoteca extends CenarioComVideoteca {
	private Videoteca b;
	private TipoId idVideo;
	private TipoVideo video;
	private TipoDadosVideoArquivavel dadosArquivo;

	public void dadoQue() {
		existeUmaVideotecaComNenhumVideo();
		existemDadosDeUmVideoArquivavel();
	}

	public void quando() {
		adicionaVideoNaVideoteca();
	}

	public void então() {
		aVideotecaPossuiUmVideo();
		éPossívelObterOVideoArmazenado();
		oVideoPossuiOsDadosDeArquivoFornecidos();
		oVideoFicaDisponível();
	}

	@Test
	public void existeUmaVideotecaComNenhumVideo() {
		b = obterVideoteca();

		assertEquals(0, b.tamanho());
	}

	private void existemDadosDeUmVideoArquivavel() {
		video = obterVideo();
		dadosArquivo = new DadosVideoArquivavel(CATÁLOGO);
	}

	private void adicionaVideoNaVideoteca() {
		idVideo = b.adicionar(video, dadosArquivo);
	}

	@Test
	public void aVideotecaPossuiUmVideo() {
		assertEquals(1, b.tamanho());
	}

	@Test
	public void éPossívelObterOVideoArmazenado() {
		assertEquals(video, b.obter(idVideo));
	}

	@Test
	public void oVideoPossuiOsDadosDeArquivoFornecidos() {
		assertEquals(dadosArquivo, b.obterDadosDeArquivo(idVideo));
	}

	@Test
	public void oVideoFicaDisponível() {
		assertEquals(DISPONÍVEL, b.obterEstadoDocumento(idVideo));
	}
}

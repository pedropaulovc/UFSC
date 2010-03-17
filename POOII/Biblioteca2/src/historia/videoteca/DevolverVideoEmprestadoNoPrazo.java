package historia.videoteca;

import static org.junit.Assert.assertEquals;
import static producao.documento.arquivavel.EstadoEmprestimo.DISPONÍVEL;
import infra.CenarioComVideoteca;

import org.junit.Test;

import producao.dados.id.TipoId;
import producao.videoteca.modelo.Videoteca;

public class DevolverVideoEmprestadoNoPrazo extends CenarioComVideoteca {
	private Videoteca b;
	private TipoId idVideo;

	public void dadoQue() {
		existeUmaVideoteca();
		aVideotecaPossuiUmVideo();
		oExemplarEstáEmprestado();
	}

	public void quando() {
		devolverOExemplarNoPrazo();
	}

	public void então() {
		oExemplarFicaráDisponível();
		oPrazoDeDevolucaoÉZero();
	}

	private void existeUmaVideoteca() {
		b = obterVideoteca();
	}

	private void aVideotecaPossuiUmVideo() {
		idVideo = b.adicionar(obterVideo());
	}

	private void oExemplarEstáEmprestado() {
		b.emprestar(idVideo);
	}

	private void devolverOExemplarNoPrazo() {
		b.devolver(idVideo);
	}

	@Test
	public void oExemplarFicaráDisponível() {
		assertEquals(DISPONÍVEL, b.obterEstadoDocumento(idVideo));
	}

	@Test
	public void oPrazoDeDevolucaoÉZero() {
		assertEquals(0, b.obterPrazoDevolucao(idVideo)
				.obterPrazoDevolucaoRelativoAHoje());
	}
}

package historia.videoteca;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static producao.documento.arquivavel.EstadoEmprestimo.EMPRESTADO;
import infra.CenarioComVideoteca;

import org.junit.Test;

import producao.dados.id.TipoId;
import producao.dados.prazoDevolucao.PrazoDevolucao;
import producao.videoteca.TipoVideoteca;

public class EmprestarVideo extends CenarioComVideoteca {
	private TipoVideoteca b;
	private TipoId idVideo;

	public void dadoQue() {
		existeUmaVideoteca();
		aVideotecaPossuiUmVideoDisponivel();
	}

	public void quando() {
		emprestarOExemplar();
	}

	public void então() {
		oExemplarFicaráEmprestado();
		oPrazoDeDevolucaoÉDe15Dias();
	}

	private void existeUmaVideoteca() {
		b = obterVideoteca();
	}

	private void aVideotecaPossuiUmVideoDisponivel() {
		idVideo = b.adicionar(obterVideo());
	}

	private void emprestarOExemplar() {
		b.emprestar(idVideo);
	}

	@Test
	public void oExemplarFicaráEmprestado() {
		assertTrue(EMPRESTADO.equals(b.obterEstadoDocumento(idVideo)));
	}

	@Test
	public void oPrazoDeDevolucaoÉDe15Dias() {
		assertEquals(new PrazoDevolucao(15), b.obterPrazoDevolucao(idVideo));
	}
}

package producao.documento.arquivavel;

import static producao.livro.EstadoEmprestimo.DISPONÍVEL;
import static producao.livro.EstadoEmprestimo.EMPRESTADO;
import producao.dados.id.Id;
import producao.dados.id.TipoId;
import producao.dados.prazoDevolucao.PrazoDevolucaoNulo;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.documento.DocumentoNulo;
import producao.documento.TipoDocumento;
import producao.livro.EstadoEmprestimo;

public class DocumentoArquivavel implements TipoDocumentoArquivavel {

	private TipoId id;
	private EstadoEmprestimo estado;
	private TipoPrazoDevolucao prazoDevolucao;
	
	public DocumentoArquivavel(){
		this.id = new Id();
		this.estado = DISPONÍVEL;
		this.prazoDevolucao = new PrazoDevolucaoNulo();
	}
	
	public boolean alterarEstado(EstadoEmprestimo estado) {
		if (estado.equals(EMPRESTADO))
			return false;
		this.estado = estado;
		return true;
	}

	public boolean devolver() {
		if (!estado.equals(EMPRESTADO)) {
			return false;
		}

		if (prazoDevolucao.estaNoPrazo()) {
			estado = DISPONÍVEL;
			prazoDevolucao = new PrazoDevolucaoNulo();
			return true;
		}
		return false;
	}

	public boolean emprestar(TipoPrazoDevolucao prazoDevolucao) {
		if (estado.equals(DISPONÍVEL)) {
			estado = EMPRESTADO;
			this.prazoDevolucao = prazoDevolucao;
			return true;
		}
		return false;
	}

	public TipoDocumento obterDocumento() {
		return new DocumentoNulo();
	}

	public EstadoEmprestimo obterEstado() {
		return estado;
	}

	public TipoId obterId() {
		return id;
	}

	public TipoPrazoDevolucao obterPrazoDevolucao() {
		return prazoDevolucao;
	}

}

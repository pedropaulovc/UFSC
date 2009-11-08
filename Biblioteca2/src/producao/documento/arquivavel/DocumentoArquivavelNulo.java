package producao.documento.arquivavel;

import static producao.documento.arquivavel.EstadoEmprestimo.NULO;
import producao.dados.id.IdNulo;
import producao.dados.id.TipoId;
import producao.dados.prazoDevolucao.PrazoDevolucaoNulo;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.documento.DocumentoNulo;
import producao.documento.TipoDocumento;
import producao.documento.arquivavel.dados.DadosDocumentoArquivavelNulo;
import producao.documento.arquivavel.dados.TipoDadosDocumentoArquivavel;

public class DocumentoArquivavelNulo implements TipoDocumentoArquivavel {

	public boolean alterarEstado(EstadoEmprestimo estado) {
		return false;
	}

	public boolean devolver() {
		return false;
	}

	public boolean emprestar(TipoPrazoDevolucao tipoPrazoDevolucao) {
		return false;
	}

	public EstadoEmprestimo obterEstado() {
		return NULO;
	}

	public TipoId obterId() {
		return new IdNulo();
	}

	public TipoPrazoDevolucao obterPrazoDevolucao() {
		return new PrazoDevolucaoNulo();
	}

	public TipoDocumento obterDocumento() {
		return new DocumentoNulo();
	}

	public TipoDadosDocumentoArquivavel obterDadosDeArquivo() {
		return new DadosDocumentoArquivavelNulo();
	}

}

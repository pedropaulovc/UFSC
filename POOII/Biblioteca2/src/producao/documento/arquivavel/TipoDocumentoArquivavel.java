package producao.documento.arquivavel;

import producao.dados.id.TipoId;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.documento.TipoDocumento;
import producao.documento.arquivavel.dados.TipoDadosDocumentoArquivavel;

public interface TipoDocumentoArquivavel {
	public TipoId obterId();

	public boolean emprestar(TipoPrazoDevolucao tipoPrazoDevolucao);

	public EstadoEmprestimo obterEstado();

	public TipoPrazoDevolucao obterPrazoDevolucao();

	public boolean devolver();

	public boolean alterarEstado(EstadoEmprestimo estado);

	public TipoDocumento obterDocumento();

	public TipoDadosDocumentoArquivavel obterDadosDeArquivo();
}

package producao.xteca;

import producao.dados.id.TipoId;
import producao.dados.nome.TipoNome;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.documento.TipoDocumento;
import producao.livro.EstadoEmprestimo;

public interface TipoXteca {
	public TipoNome obterNome();

	public int tamanho();

	public void removerLivro(TipoId documento);

	public boolean emprestar(TipoId idDocumento);

	public EstadoEmprestimo obterEstadoDocumento(TipoId idExemplar);

	public TipoPrazoDevolucao obterPrazoDevolucao(TipoId idDocumento);

	public boolean devolver(TipoId idDocumento);

	public boolean alterarEstado(TipoId idDocumento, EstadoEmprestimo estado);

	public TipoDocumento obterDocumento(TipoId idDocumento);
}

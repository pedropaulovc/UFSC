package producao.livroArquivavel;

import producao.dados.id.TipoId;
import producao.dados.numeroChamada.TipoNumeroChamada;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.livro.EstadoEmprestimo;
import producao.livro.TipoLivro;

public interface TipoLivroArquivavel extends TipoLivro {
	public TipoId obterId();

	public TipoNumeroChamada obterNumeroChamada();

	public boolean emprestar(TipoPrazoDevolucao tipoPrazoDevolucao);

	public EstadoEmprestimo obterEstado();

	public TipoPrazoDevolucao obterPrazoDevolucao();

	public boolean devolver();

	public boolean alterarEstado(EstadoEmprestimo estado);

	public TipoLivro obterLivro();
}

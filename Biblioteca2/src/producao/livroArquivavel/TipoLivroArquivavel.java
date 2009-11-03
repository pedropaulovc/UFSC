package producao.livroArquivavel;

import producao.dados.id.TipoId;
import producao.dados.numeroChamada.TipoNumeroChamada;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.livro.TipoLivro;
import producao.livroArquivavel.devolucao.TipoDevolucao;
import producao.livroArquivavel.emprestimo.EstadoEmprestimo;

public interface TipoLivroArquivavel extends TipoLivro {
	public TipoId obterId();
	
	public TipoNumeroChamada obterNumeroChamada();

	public boolean emprestar(TipoPrazoDevolucao tipoPrazoDevolucao);

	public EstadoEmprestimo obterEstado();

	public TipoPrazoDevolucao obterPrazoDevolucao();

	public TipoDevolucao devolver();

	public boolean alterarEstado(EstadoEmprestimo estado);

	public TipoLivro obterLivro();
}

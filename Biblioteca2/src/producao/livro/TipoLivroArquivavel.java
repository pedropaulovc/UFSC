package producao.livro;

import producao.livro.exemplar.EstadoEmprestimo;
import producao.livro.exemplar.numeroChamada.TipoNumeroChamada;
import producao.livro.exemplar.prazoDevolucao.TipoPrazoDevolucao;
import producao.livro.id.TipoIdLivro;

public interface TipoLivroArquivavel extends TipoLivro {
	public TipoIdLivro obterId();
	
	public TipoNumeroChamada obterNumeroChamada();

	public boolean emprestar(TipoPrazoDevolucao tipoPrazoDevolucao);

	public EstadoEmprestimo obterEstado();

	public TipoPrazoDevolucao obterPrazoDevolucao();

	public boolean devolver();

	public boolean alterarEstado(EstadoEmprestimo estado);
}

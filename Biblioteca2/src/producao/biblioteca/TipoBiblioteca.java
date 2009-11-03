package producao.biblioteca;

import producao.dados.id.TipoId;
import producao.dados.nome.TipoNome;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.livro.EstadoEmprestimo;
import producao.livro.TipoLivro;

public interface TipoBiblioteca {
	public TipoNome obterNome();

	public int tamanho();

	public TipoId adicionar(TipoLivro livro);

	public void removerLivro(TipoId livro);

	public boolean emprestar(TipoId idLivro);

	public EstadoEmprestimo obterEstadoLivro(TipoId idExemplar);

	public TipoPrazoDevolucao obterPrazoDevolucao(TipoId idExemplar);

	public boolean devolver(TipoId idExemplar);

	public boolean alterarEstado(TipoId idLivro, EstadoEmprestimo estado);

	public TipoLivro obterLivro(TipoId idLivro);
}

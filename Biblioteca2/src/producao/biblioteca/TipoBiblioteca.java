package producao.biblioteca;

import producao.dados.nome.TipoNome;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.livro.EstadoEmprestimo;
import producao.livro.TipoLivro;
import producao.livro.id.TipoIdLivro;

public interface TipoBiblioteca {
	public TipoNome obterNome();

	public int tamanho();

	public TipoIdLivro adicionar(TipoLivro livro);

	public void removerLivro(TipoIdLivro livro);

	public boolean emprestar(TipoIdLivro idLivro);

	public EstadoEmprestimo obterEstadoLivro(TipoIdLivro idExemplar);

	public TipoPrazoDevolucao obterPrazoDevolucao(TipoIdLivro idExemplar);

	public boolean devolver(TipoIdLivro idExemplar);

	public boolean alterarEstado(TipoIdLivro idLivro, EstadoEmprestimo estado);

	public TipoLivro obterLivro(TipoIdLivro idLivro);
}

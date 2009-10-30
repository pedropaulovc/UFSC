package producao.biblioteca;

import producao.biblioteca.nome.TipoNomeBiblioteca;
import producao.livro.TipoLivro;
import producao.livro.exemplar.EstadoEmprestimo;
import producao.livro.exemplar.prazoDevolucao.TipoPrazoDevolucao;
import producao.livro.id.TipoIdLivro;

public interface TipoBiblioteca {
	public TipoNomeBiblioteca obterNome();

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

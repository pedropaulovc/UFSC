package producao.biblioteca;

import producao.biblioteca.nome.TipoNomeBiblioteca;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.exemplar.EstadoEmprestimo;
import producao.livro.exemplar.dados.TipoDadosExemplarArquivavel;
import producao.livro.exemplar.id.TipoIdExemplar;
import producao.livro.exemplar.prazoDevolucao.TipoPrazoDevolucao;
import producao.livro.id.TipoIdLivro;

public interface TipoBiblioteca {
	public TipoNomeBiblioteca obterNome();

	public int tamanho();

	public TipoIdLivro adicionar(TipoDadosLivro livro);

	public TipoIdExemplar adicionarExemplar(TipoIdLivro livro,
			TipoDadosExemplarArquivavel exemplar);

	public void removerLivro(TipoIdLivro livro);

	public TipoDadosLivro obterDadosLivro(TipoIdLivro livro);

	public TipoDadosExemplarArquivavel obterDadosExemplar(TipoIdExemplar exemplar);

	public int qtdExemplares(TipoIdLivro livro);

	public void removerExemplar(TipoIdExemplar exemplar);

	public boolean emprestar(TipoIdExemplar idExemplar);

	public EstadoEmprestimo obterEstadoExemplar(TipoIdExemplar idExemplar);

	public TipoPrazoDevolucao obterPrazoDevolucao(TipoIdExemplar idExemplar);

	public boolean devolver(TipoIdExemplar idExemplar);
}

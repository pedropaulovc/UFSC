package producao;

import producao.livro.EstadoEmprestimo;
import producao.livro.TipoDadosExemplarArquivavel;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoIdentificacaoExemplar;
import producao.livro.TipoIdentificacaoLivro;
import producao.livro.TipoPrazoDevolucao;

public interface TipoBiblioteca {
	public TipoNomeBiblioteca obterNome();

	public int tamanho();

	public TipoIdentificacaoLivro adicionar(TipoDadosLivro livro);

	public TipoIdentificacaoExemplar adicionarExemplar(TipoIdentificacaoLivro livro,
			TipoDadosExemplarArquivavel exemplar);

	public void removerLivro(TipoIdentificacaoLivro livro);

	public TipoDadosLivro obterDadosLivro(TipoIdentificacaoLivro livro);

	public TipoDadosExemplarArquivavel obterDadosExemplar(TipoIdentificacaoExemplar exemplar);

	public int qtdExemplares(TipoIdentificacaoLivro livro);

	public void removerExemplar(TipoIdentificacaoExemplar exemplar);

	public boolean emprestar(TipoIdentificacaoExemplar idExemplar);

	public EstadoEmprestimo obterEstadoExemplar(TipoIdentificacaoExemplar idExemplar);

	public TipoPrazoDevolucao obterPrazoDevolucao(TipoIdentificacaoExemplar idExemplar);

	public boolean devolver(TipoIdentificacaoExemplar idExemplar);
}

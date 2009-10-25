package producao;

import producao.livro.TipoDadosExemplarArquivavel;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoIdentificacaoExemplar;
import producao.livro.TipoIdentificacaoLivro;

public interface TipoBiblioteca {
	public TipoNomeBiblioteca obterNome();

	public int tamanho();

	public TipoIdentificacaoLivro adicionar(TipoDadosLivro livro);

	public TipoIdentificacaoExemplar adicionarExemplar(TipoIdentificacaoLivro livro,
			TipoDadosExemplarArquivavel exemplar);

	public void removerLivro(TipoIdentificacaoLivro livro);

	public TipoDadosLivro obterDadosLivro(TipoIdentificacaoLivro livro);

	public TipoDadosExemplarArquivavel obterDadosExemplar(
			TipoIdentificacaoLivro livro, TipoIdentificacaoExemplar exemplar);

	public int qtdExemplares(TipoIdentificacaoLivro livro);

	public void removerExemplar(TipoIdentificacaoLivro livro,
			TipoIdentificacaoExemplar exemplar);
}

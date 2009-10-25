package producao;

import producao.livro.TipoDadosExemplarArquivavel;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoIdentificacao;

public interface TipoBiblioteca {
	public TipoNomeBiblioteca obterNome();

	public int tamanho();

	public void adicionar(TipoDadosLivro livro);

	public void adicionarExemplar(TipoIdentificacao livro,
			TipoDadosExemplarArquivavel exemplar);

	public void removerLivro(TipoIdentificacao livro);

	public TipoDadosLivro obterDadosLivro(TipoIdentificacao livro);

	public TipoDadosExemplarArquivavel obterDadosExemplar(
			TipoIdentificacao livro, TipoIdentificacao exemplar);

	public int qtdExemplares(TipoIdentificacao livro);

	public void removerExemplar(TipoIdentificacao livro,
			TipoIdentificacao exemplar);
}

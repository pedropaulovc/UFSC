package producao;

import producao.livro.TipoLivroComExemplaresArquivaveis;

public interface TipoBiblioteca {
	public TipoNomeBiblioteca obterNome();
	
	public int tamanho();

	public boolean adicionar(TipoLivroComExemplaresArquivaveis livro);

	public TipoLivroComExemplaresArquivaveis obterLivro(int i);

	public TipoLivroComExemplaresArquivaveis removerLivro(int i);
}

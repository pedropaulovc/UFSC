package producao;

import producao.livro.TipoLivroArquivavel;

public interface TipoBiblioteca {
	public TipoNomeBiblioteca obterNome();
	
	public int tamanho();

	public boolean adicionar(TipoLivroArquivavel livro);

	public TipoLivroArquivavel obterLivro(int i);

	public TipoLivroArquivavel removerLivro(int i);
}

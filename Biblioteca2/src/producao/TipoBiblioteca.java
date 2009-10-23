package producao;

import producao.livro.TipoLivro;

public interface TipoBiblioteca {
	public TipoNomeBiblioteca obterNome();
	
	public int tamanho();

	public boolean adicionar(TipoLivro livro);

	public TipoLivro obterLivro(int i);

	public TipoLivro removerLivro(int i);
}

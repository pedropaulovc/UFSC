package producao;

import producao.livro.TipoDadosExemplar;
import producao.livro.TipoDadosLivro;

public interface TipoBiblioteca {
	public TipoNomeBiblioteca obterNome();
	
	public int tamanho();

	public boolean adicionar(TipoDadosLivro livro);
	
	public boolean adicionarExemplar(int livro, TipoDadosExemplar exemplar);

	public void removerLivro(int i);
	
	public TipoDadosLivro obterDadosLivro(int i);
	
	public TipoDadosExemplar obterDadosExemplar(int livro, int exemplar);
	
	public int qtdExemplares(int livro);

	public void removerExemplar(int livro, int exemplar);
}

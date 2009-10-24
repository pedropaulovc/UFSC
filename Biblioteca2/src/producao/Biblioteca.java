package producao;

import java.util.ArrayList;
import java.util.List;

import producao.livro.TipoLivroComExemplaresArquivaveis;

public class Biblioteca implements TipoBiblioteca {

	private TipoConfiguracaoBiblioteca configuracao;
	private List<TipoLivroComExemplaresArquivaveis> listaLivros;

	public Biblioteca(TipoConfiguracaoBiblioteca configuração) {
		this.configuracao = configuração;
		this.listaLivros = new ArrayList<TipoLivroComExemplaresArquivaveis>();
	}

	public TipoNomeBiblioteca obterNome() {
		return configuracao.obterNomeBiblioteca();
	}

	public int tamanho() {
		return listaLivros.size();
	}

	public boolean adicionar(TipoLivroComExemplaresArquivaveis livro) {
		return listaLivros.add(livro);
	}

	public TipoLivroComExemplaresArquivaveis obterLivro(int i) {
		return listaLivros.get(i - 1);
	}

	public TipoLivroComExemplaresArquivaveis removerLivro(int i) {
		return listaLivros.remove(i - 1);
	}
}

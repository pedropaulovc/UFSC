package producao;

import java.util.ArrayList;
import java.util.List;

import producao.livro.TipoLivro;

public class Biblioteca implements TipoBiblioteca {

	private TipoConfiguracaoBiblioteca configuracao;
	private List<TipoLivro> listaLivros;

	public Biblioteca(TipoConfiguracaoBiblioteca configuração) {
		this.configuracao = configuração;
		this.listaLivros = new ArrayList<TipoLivro>();
	}

	public TipoNomeBiblioteca obterNome() {
		return configuracao.obterNomeBiblioteca();
	}

	public int tamanho() {
		return listaLivros.size();
	}

	public boolean adicionar(TipoLivro livro) {
		return listaLivros.add(livro);
	}

	public TipoLivro obterLivro(int i) {
		return listaLivros.get(i - 1);
	}

	public TipoLivro removerLivro(int i) {
		return listaLivros.remove(i - 1);
	}
}

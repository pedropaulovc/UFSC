package producao;

import java.util.ArrayList;
import java.util.List;

import producao.livro.TipoLivroArquivavel;

public class Biblioteca implements TipoBiblioteca {

	private TipoConfiguracaoBiblioteca configuracao;
	private List<TipoLivroArquivavel> listaLivros;

	public Biblioteca(TipoConfiguracaoBiblioteca configuração) {
		this.configuracao = configuração;
		this.listaLivros = new ArrayList<TipoLivroArquivavel>();
	}

	public TipoNomeBiblioteca obterNome() {
		return configuracao.obterNomeBiblioteca();
	}

	public int tamanho() {
		return listaLivros.size();
	}

	public boolean adicionar(TipoLivroArquivavel livro) {
		return listaLivros.add(livro);
	}

	public TipoLivroArquivavel obterLivro(int i) {
		return listaLivros.get(i - 1);
	}

	public TipoLivroArquivavel removerLivro(int i) {
		return listaLivros.remove(i - 1);
	}
}

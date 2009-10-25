package producao;

import java.util.ArrayList;
import java.util.List;

import producao.livro.EditoraBiblioteca;
import producao.livro.TipoDadosExemplar;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEditoraBiblioteca;
import producao.livro.TipoLivroComExemplaresArquivaveis;

public class Biblioteca implements TipoBiblioteca {

	private TipoConfiguracaoBiblioteca configuracao;
	private List<TipoLivroComExemplaresArquivaveis> listaLivros;
	private TipoEditoraBiblioteca editora;

	public Biblioteca(TipoConfiguracaoBiblioteca configuração) {
		this.configuracao = configuração;
		this.listaLivros = new ArrayList<TipoLivroComExemplaresArquivaveis>();
		this.editora = new EditoraBiblioteca();
	}

	public boolean adicionar(TipoDadosLivro dados) {
		return listaLivros.add(editora.criarLivroComExemplaresArquivaveis(dados));
	}

	public boolean adicionarExemplar(int livro, TipoDadosExemplar dadosExemplar) {
		return listaLivros.get(livro - 1).adicionarExemplar(dadosExemplar);
	}
	
	public TipoNomeBiblioteca obterNome() {
		return configuracao.obterNomeBiblioteca();
	}

	public int tamanho() {
		return listaLivros.size();
	}

	public void removerLivro(int i) {
		listaLivros.remove(i - 1);
	}
	
	public TipoDadosLivro obterDadosLivro(int i){
		return listaLivros.get(i - 1).obterDados();
	}
	
	public TipoDadosExemplar obterDadosExemplar(int livro, int exemplar){
		return listaLivros.get(livro - 1).obterDadosExemplar(exemplar);
	}

	public int qtdExemplares(int livro) {
		return listaLivros.get(livro - 1).qtdExemplares();
	}

	@Override
	public void removerExemplar(int livro, int exemplar) {
		listaLivros.get(livro - 1).removerExemplar(exemplar);
	}

}

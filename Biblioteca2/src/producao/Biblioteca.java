package producao;

import java.util.HashMap;
import java.util.Map;

import producao.livro.EditoraBiblioteca;
import producao.livro.TipoDadosExemplarArquivavel;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEditoraBiblioteca;
import producao.livro.TipoIdentificacao;
import producao.livro.TipoLivroComExemplaresArquivaveis;

public class Biblioteca implements TipoBiblioteca {

	private TipoConfiguracaoBiblioteca configuracao;
	private Map<TipoIdentificacao, TipoLivroComExemplaresArquivaveis> mapaLivros;
	private TipoEditoraBiblioteca editora;

	public Biblioteca(TipoConfiguracaoBiblioteca configuração) {
		this.configuracao = configuração;
		this.mapaLivros = new HashMap<TipoIdentificacao, TipoLivroComExemplaresArquivaveis>();
		this.editora = new EditoraBiblioteca();
	}

	public TipoNomeBiblioteca obterNome() {
		return configuracao.obterNomeBiblioteca();
	}

	public int tamanho() {
		return mapaLivros.size();
	}

	public TipoIdentificacao adicionar(TipoDadosLivro dadosLivro) {
		mapaLivros.put(dadosLivro.obterIdentificacao(), editora
				.criarLivroComExemplaresArquivaveis(dadosLivro));
		
		return dadosLivro.obterIdentificacao();
	}

	public TipoIdentificacao adicionarExemplar(TipoIdentificacao livro,
			TipoDadosExemplarArquivavel dadosExemplar) {
		mapaLivros.get(livro).adicionarExemplar(dadosExemplar);
		
		return dadosExemplar.obterIdentificacao();
	}

	public TipoDadosExemplarArquivavel obterDadosExemplar(
			TipoIdentificacao livro, TipoIdentificacao exemplar) {
		return mapaLivros.get(livro).obterDadosExemplar(exemplar);
	}

	public TipoDadosLivro obterDadosLivro(TipoIdentificacao livro) {
		return mapaLivros.get(livro).obterDados();
	}

	public int qtdExemplares(TipoIdentificacao livro) {
		return mapaLivros.get(livro).qtdExemplares();
	}

	public void removerExemplar(TipoIdentificacao livro,
			TipoIdentificacao exemplar) {
		mapaLivros.get(livro).removerExemplar(exemplar);
	}

	public void removerLivro(TipoIdentificacao livro) {
		mapaLivros.remove(livro);
	}
}

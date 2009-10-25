package producao;

import java.util.HashMap;
import java.util.Map;

import producao.livro.EditoraBiblioteca;
import producao.livro.TipoDadosExemplarArquivavel;
import producao.livro.TipoDadosLivro;
import producao.livro.TipoEditoraBiblioteca;
import producao.livro.TipoIdentificacaoExemplar;
import producao.livro.TipoIdentificacaoLivro;
import producao.livro.TipoLivroComExemplaresArquivaveis;

public class Biblioteca implements TipoBiblioteca {

	private TipoConfiguracaoBiblioteca configuracao;
	private Map<TipoIdentificacaoLivro, TipoLivroComExemplaresArquivaveis> mapaLivros;
	private TipoEditoraBiblioteca editora;

	public Biblioteca(TipoConfiguracaoBiblioteca configuração) {
		this.configuracao = configuração;
		this.mapaLivros = new HashMap<TipoIdentificacaoLivro, TipoLivroComExemplaresArquivaveis>();
		this.editora = new EditoraBiblioteca();
	}

	public TipoNomeBiblioteca obterNome() {
		return configuracao.obterNomeBiblioteca();
	}

	public int tamanho() {
		return mapaLivros.size();
	}

	public TipoIdentificacaoLivro adicionar(TipoDadosLivro dadosLivro) {
		mapaLivros.put(dadosLivro.obterIdentificacao(), editora
				.criarLivroComExemplaresArquivaveis(dadosLivro));
		
		return dadosLivro.obterIdentificacao();
	}

	public TipoIdentificacaoExemplar adicionarExemplar(TipoIdentificacaoLivro livro,
			TipoDadosExemplarArquivavel dadosExemplar) {
		mapaLivros.get(livro).adicionarExemplar(dadosExemplar);
		
		return dadosExemplar.obterIdentificacao();
	}

	public TipoDadosExemplarArquivavel obterDadosExemplar(
			TipoIdentificacaoLivro livro, TipoIdentificacaoExemplar exemplar) {
		return mapaLivros.get(livro).obterDadosExemplar(exemplar);
	}

	public TipoDadosLivro obterDadosLivro(TipoIdentificacaoLivro livro) {
		return mapaLivros.get(livro).obterDados();
	}

	public int qtdExemplares(TipoIdentificacaoLivro livro) {
		return mapaLivros.get(livro).qtdExemplares();
	}

	public void removerExemplar(TipoIdentificacaoLivro livro,
			TipoIdentificacaoExemplar exemplar) {
		mapaLivros.get(livro).removerExemplar(exemplar);
	}

	public void removerLivro(TipoIdentificacaoLivro livro) {
		mapaLivros.remove(livro);
	}
}

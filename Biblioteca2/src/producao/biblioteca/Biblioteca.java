package producao.biblioteca;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import producao.biblioteca.configuracao.TipoConfiguracaoBiblioteca;
import producao.biblioteca.nome.TipoNomeBiblioteca;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.editora.EditoraBiblioteca;
import producao.livro.editora.TipoEditoraBiblioteca;
import producao.livro.exemplar.EstadoEmprestimo;
import producao.livro.exemplar.TipoLivroComExemplaresArquivaveis;
import producao.livro.exemplar.dados.TipoDadosExemplarArquivavel;
import producao.livro.exemplar.id.TipoIdExemplar;
import producao.livro.exemplar.prazoDevolucao.TipoPrazoDevolucao;
import producao.livro.id.TipoIdLivro;

public class Biblioteca implements TipoBiblioteca {

	private TipoConfiguracaoBiblioteca config;
	private Map<TipoIdLivro, TipoLivroComExemplaresArquivaveis> mapaLivros;
	private TipoEditoraBiblioteca editora;

	public Biblioteca(TipoConfiguracaoBiblioteca configuração) {
		this.config = configuração;
		this.mapaLivros = new HashMap<TipoIdLivro, TipoLivroComExemplaresArquivaveis>();
		this.editora = new EditoraBiblioteca();
	}

	public TipoNomeBiblioteca obterNome() {
		return config.obterNomeBiblioteca();
	}

	public int tamanho() {
		return mapaLivros.size();
	}

	public TipoIdLivro adicionar(TipoDadosLivro dadosLivro) {
		mapaLivros.put(dadosLivro.obterIdentificacao(), editora
				.criarLivroComExemplaresArquivaveis(dadosLivro));

		return dadosLivro.obterIdentificacao();
	}

	public TipoIdExemplar adicionarExemplar(
			TipoIdLivro livro,
			TipoDadosExemplarArquivavel dadosExemplar) {
		mapaLivros.get(livro).adicionarExemplar(dadosExemplar);

		return dadosExemplar.obterIdentificacao();
	}

	public TipoDadosExemplarArquivavel obterDadosExemplar(
			TipoIdExemplar exemplar) {
		return buscarLivro(exemplar).obterDadosExemplar(exemplar);
	}

	public TipoDadosLivro obterDadosLivro(TipoIdLivro livro) {
		return mapaLivros.get(livro).obterDados();
	}

	public int qtdExemplares(TipoIdLivro livro) {
		return mapaLivros.get(livro).qtdExemplares();
	}

	public void removerExemplar(TipoIdExemplar exemplar) {
		buscarLivro(exemplar).removerExemplar(exemplar);
	}

	public void removerLivro(TipoIdLivro livro) {
		mapaLivros.remove(livro);
	}

	private TipoLivroComExemplaresArquivaveis buscarLivro(
			TipoIdExemplar exemplar) {
		String mensagemErro = "Identificação fornecida não existe no acervo";

		for (TipoLivroComExemplaresArquivaveis l : mapaLivros.values())
			if (l.contemExemplar(exemplar))
				return l;
		throw new InvalidParameterException(mensagemErro);
	}

	public boolean emprestar(TipoIdExemplar idExemplar) {
		return buscarLivro(idExemplar).emprestar(idExemplar,
				config.obterPrazoDevolucao());
	}

	public EstadoEmprestimo obterEstadoExemplar(
			TipoIdExemplar idExemplar) {
		return buscarLivro(idExemplar).obterEstado(idExemplar);
	}

	public TipoPrazoDevolucao obterPrazoDevolucao(TipoIdExemplar idExemplar) {
		return buscarLivro(idExemplar).obterPrazoDevolucao(idExemplar);
	}

	public boolean devolver(TipoIdExemplar idExemplar) {
		return buscarLivro(idExemplar).devolver(idExemplar);
	}
}

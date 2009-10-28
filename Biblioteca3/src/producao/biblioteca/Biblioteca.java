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
	private String erroId = "Identificação fornecida não existe no acervo";

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
		mapaLivros.put(dadosLivro.obterId(), editora
				.criarLivroComExemplaresArquivaveis(dadosLivro));

		return dadosLivro.obterId();
	}

	public TipoIdExemplar adicionarExemplar(TipoIdLivro livro,
			TipoDadosExemplarArquivavel dadosExemplar) {

		if (mapaLivros.containsKey(livro)) {
			mapaLivros.get(livro).adicionarExemplar(dadosExemplar);
			return dadosExemplar.obterId();
		}
		throw new InvalidParameterException(erroId);
	}

	public TipoDadosExemplarArquivavel obterDadosExemplar(
			TipoIdExemplar exemplar) {
		return buscarLivro(exemplar).obterDadosExemplar(exemplar);
	}

	public TipoDadosLivro obterDadosLivro(TipoIdLivro idLivro) {
		if (mapaLivros.containsKey(idLivro))
			return mapaLivros.get(idLivro).obterDados();
		throw new InvalidParameterException(erroId);
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
		for (TipoLivroComExemplaresArquivaveis l : mapaLivros.values())
			if (l.contemExemplar(exemplar))
				return l;
		throw new InvalidParameterException(erroId);
	}

	public boolean emprestar(TipoIdExemplar idExemplar) {
		return buscarLivro(idExemplar).emprestar(idExemplar,
				config.obterPrazoDevolucao());
	}

	public EstadoEmprestimo obterEstadoExemplar(TipoIdExemplar idExemplar) {
		return buscarLivro(idExemplar).obterEstado(idExemplar);
	}

	public TipoPrazoDevolucao obterPrazoDevolucao(TipoIdExemplar idExemplar) {
		return buscarLivro(idExemplar).obterPrazoDevolucao(idExemplar);
	}

	public boolean devolver(TipoIdExemplar idExemplar) {
		return buscarLivro(idExemplar).devolver(idExemplar);
	}

	public boolean alterarEstado(TipoIdExemplar idExemplar,
			EstadoEmprestimo estado) {
		return buscarLivro(idExemplar).alterarEstado(idExemplar, estado);
	}
}

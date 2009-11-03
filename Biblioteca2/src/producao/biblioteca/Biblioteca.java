package producao.biblioteca;

import java.util.HashMap;
import java.util.Map;

import producao.biblioteca.configuracao.TipoConfiguracaoBiblioteca;
import producao.dados.id.TipoId;
import producao.dados.nome.TipoNome;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.livro.TipoLivro;
import producao.livroArquivavel.LivroArquivavel;
import producao.livroArquivavel.LivroArquivavelNulo;
import producao.livroArquivavel.TipoLivroArquivavel;
import producao.livroArquivavel.devolucao.TipoDevolucao;
import producao.livroArquivavel.emprestimo.EstadoEmprestimo;

public class Biblioteca implements TipoBiblioteca {

	private TipoConfiguracaoBiblioteca config;
	private Map<TipoId, TipoLivroArquivavel> mapaLivros;

	public Biblioteca(TipoConfiguracaoBiblioteca configuração) {
		assert configuração != null;

		this.config = configuração;
		this.mapaLivros = new HashMap<TipoId, TipoLivroArquivavel>();
	}

	public TipoNome obterNome() {
		return config.obterNomeBiblioteca();
	}

	public int tamanho() {
		return mapaLivros.size();
	}

	public void removerLivro(TipoId livro) {
		mapaLivros.remove(livro);
	}

	public TipoId adicionar(TipoLivro livro) {
		TipoLivroArquivavel arquivavel = new LivroArquivavel(livro);
		mapaLivros.put(arquivavel.obterId(), arquivavel);

		return arquivavel.obterId();
	}

	public boolean alterarEstado(TipoId idLivro, EstadoEmprestimo estado) {
		return buscarLivro(idLivro).alterarEstado(estado);
	}

	public TipoDevolucao devolver(TipoId idLivro) {
		return buscarLivro(idLivro).devolver();
	}

	public boolean emprestar(TipoId idLivro) {
		return buscarLivro(idLivro).emprestar(
				config.obterNovoPrazoDevolucao());
	}

	public EstadoEmprestimo obterEstadoLivro(TipoId idLivro) {
		return buscarLivro(idLivro).obterEstado();
	}

	public TipoLivro obterLivro(TipoId idLivro) {
		return buscarLivro(idLivro).obterLivro();
	}

	public TipoPrazoDevolucao obterPrazoDevolucao(TipoId idLivro) {
		return buscarLivro(idLivro).obterPrazoDevolucao();
	}

	private TipoLivroArquivavel buscarLivro(TipoId idLivro) {
		TipoLivroArquivavel livro = mapaLivros.get(idLivro);
		if (livro != null)
			return livro;
		return new LivroArquivavelNulo();
	}

}

package producao.biblioteca;

import java.util.HashMap;
import java.util.Map;

import producao.biblioteca.configuracao.TipoConfiguracaoBiblioteca;
import producao.dados.id.TipoId;
import producao.dados.nome.TipoNome;
import producao.dados.prazoDevolucao.PrazoDevolucao;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.livro.EstadoEmprestimo;
import producao.livro.TipoLivro;
import producao.livroArquivavel.LivroArquivavel;
import producao.livroArquivavel.LivroArquivavelNulo;
import producao.livroArquivavel.TipoLivroArquivavel;
import producao.livroArquivavel.dados.DadosLivroArquivavelNulo;

public class Biblioteca implements TipoBiblioteca {

	private TipoConfiguracaoBiblioteca config;
	private Map<TipoId, TipoLivroArquivavel> mapaLivros;

	public Biblioteca(TipoConfiguracaoBiblioteca configuração) {
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
		TipoLivroArquivavel arquivavel = new LivroArquivavel(livro,
				new DadosLivroArquivavelNulo());
		mapaLivros.put(arquivavel.obterId(), arquivavel);

		return arquivavel.obterId();
	}

	public boolean alterarEstado(TipoId idLivro, EstadoEmprestimo estado) {
		return mapaLivros.get(idLivro).alterarEstado(estado);
	}

	public boolean devolver(TipoId idLivro) {
		return mapaLivros.get(idLivro).devolver();
	}

	public boolean emprestar(TipoId idLivro) {
		return mapaLivros.get(idLivro).emprestar(
				new PrazoDevolucao(config.obterPrazoDevolucaoInteiro()));
	}

	public EstadoEmprestimo obterEstadoLivro(TipoId idLivro) {
		return mapaLivros.get(idLivro).obterEstado();
	}

	public TipoLivro obterLivro(TipoId idLivro) {
		return obterLivroArquivavel(idLivro).obterLivro();
	}

	public TipoPrazoDevolucao obterPrazoDevolucao(TipoId idLivro) {
		return mapaLivros.get(idLivro).obterPrazoDevolucao();
	}
	
	private TipoLivroArquivavel obterLivroArquivavel(TipoId idLivro){
		TipoLivroArquivavel livro = mapaLivros.get(idLivro);
		if(livro != null)
			return livro;
		return new LivroArquivavelNulo();	
	}

}

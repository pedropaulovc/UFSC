package producao.biblioteca;

import java.util.HashMap;
import java.util.Map;

import producao.biblioteca.configuracao.TipoConfiguracaoBiblioteca;
import producao.biblioteca.nome.TipoNomeBiblioteca;
import producao.livro.EstadoEmprestimo;
import producao.livro.TipoLivro;
import producao.livro.TipoLivroArquivavel;
import producao.livro.exemplar.prazoDevolucao.PrazoDevolucao;
import producao.livro.exemplar.prazoDevolucao.TipoPrazoDevolucao;
import producao.livro.id.TipoIdLivro;

public class Biblioteca implements TipoBiblioteca {

	private TipoConfiguracaoBiblioteca config;
	private Map<TipoIdLivro, TipoLivroArquivavel> mapaLivros;

	public Biblioteca(TipoConfiguracaoBiblioteca configuração) {
		this.config = configuração;
		this.mapaLivros = new HashMap<TipoIdLivro, TipoLivroArquivavel>();
	}

	public TipoNomeBiblioteca obterNome() {
		return config.obterNomeBiblioteca();
	}

	public int tamanho() {
		return mapaLivros.size();
	}

	public void removerLivro(TipoIdLivro livro) {
		mapaLivros.remove(livro);
	}

	public TipoIdLivro adicionar(TipoLivro livro) {
		TipoLivroArquivavel arquivavel = new LivroArquivavel(livro,
				new DadosLivroArquivavelNulo());
		mapaLivros.put(arquivavel.obterId(), arquivavel);

		return arquivavel.obterId();
	}

	public boolean alterarEstado(TipoIdLivro idLivro, EstadoEmprestimo estado) {
		return mapaLivros.get(idLivro).alterarEstado(estado);
	}

	public boolean devolver(TipoIdLivro idLivro) {
		return mapaLivros.get(idLivro).devolver();
	}

	public boolean emprestar(TipoIdLivro idLivro) {
		return mapaLivros.get(idLivro).emprestar(
				new PrazoDevolucao(config.obterPrazoDevolucaoInteiro()));
	}

	public EstadoEmprestimo obterEstadoLivro(TipoIdLivro idLivro) {
		return mapaLivros.get(idLivro).obterEstado();
	}

	public TipoLivro obterLivro(TipoIdLivro idLivro) {
		return obterLivroArquivavel(idLivro).obterLivro();
	}

	public TipoPrazoDevolucao obterPrazoDevolucao(TipoIdLivro idLivro) {
		return mapaLivros.get(idLivro).obterPrazoDevolucao();
	}
	
	private TipoLivroArquivavel obterLivroArquivavel(TipoIdLivro idLivro){
		TipoLivroArquivavel livro = mapaLivros.get(idLivro);
		if(livro != null)
			return livro;
		return new LivroArquivavelNulo();	
	}

}

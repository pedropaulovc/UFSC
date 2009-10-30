package producao.biblioteca.configuracao;

import producao.biblioteca.nome.TipoNomeBiblioteca;
import producao.livro.exemplar.prazoDevolucao.TipoPrazoDevolucao;


public class ConfiguracaoBiblioteca implements TipoConfiguracaoBiblioteca {
	private TipoNomeBiblioteca nome;
	private int prazoDevolucao;

	/**
	 * @param configuracao  Uma string contendo as configurações da biblioteca, separados
	 *  por ponto vírgula e na ordem "Nome da Biblioteca;Prazo de entrega dos livros"
	 */
	public ConfiguracaoBiblioteca(TipoNomeBiblioteca nome, TipoPrazoDevolucao prazo){		
		this.nome = nome;
		this.prazoDevolucao = prazo.obterPrazoInteiro();
	}

	public TipoNomeBiblioteca obterNomeBiblioteca(){
		return nome;
	}
	
	public int obterPrazoDevolucaoInteiro(){
		return prazoDevolucao;
	}
}

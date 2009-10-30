package producao.biblioteca.configuracao;

import producao.dados.nome.TipoNome;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;


public class ConfiguracaoBiblioteca implements TipoConfiguracaoBiblioteca {
	private TipoNome nome;
	private int prazoDevolucao;

	/**
	 * @param configuracao  Uma string contendo as configurações da biblioteca, separados
	 *  por ponto vírgula e na ordem "Nome da Biblioteca;Prazo de entrega dos livros"
	 */
	public ConfiguracaoBiblioteca(TipoNome nome, TipoPrazoDevolucao prazo){		
		this.nome = nome;
		this.prazoDevolucao = prazo.obterPrazoInteiro();
	}

	public TipoNome obterNomeBiblioteca(){
		return nome;
	}
	
	public int obterPrazoDevolucaoInteiro(){
		return prazoDevolucao;
	}
}

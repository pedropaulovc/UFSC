package producao.biblioteca.configuracao;

import producao.biblioteca.nome.NomeBiblioteca;
import producao.biblioteca.nome.TipoNomeBiblioteca;


public class ConfiguracaoBiblioteca implements TipoConfiguracaoBiblioteca {
	private TipoNomeBiblioteca nome;
	private int prazoDevolucao;

	/**
	 * @param configuracao  Uma string contendo as configurações da biblioteca, separados
	 *  por ponto vírgula e na ordem "Nome da Biblioteca;Prazo de entrega dos livros"
	 */
	public ConfiguracaoBiblioteca(String configuracao){
		assert(configuracao != null);
		
		String[] configuracoesSeparadas = configuracao.split(";");
		assert(configuracoesSeparadas.length == 2);
		
		this.nome = new NomeBiblioteca(configuracoesSeparadas[0]);
		this.prazoDevolucao = Integer.parseInt(configuracoesSeparadas[1]);
	}
	
	public TipoNomeBiblioteca obterNomeBiblioteca(){
		return nome;
	}
	
	public int obterPrazoDevolucao(){
		return prazoDevolucao;
	}
}

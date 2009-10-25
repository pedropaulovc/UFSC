package producao;


public class ConfiguracaoBiblioteca implements TipoConfiguracaoBiblioteca {
	private TipoNomeBiblioteca nome;
	private int prazoDevolucao;

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

package producao;

public class ConfiguracaoBiblioteca implements TipoConfiguracaoBiblioteca {
	private TipoNomeBiblioteca nome;

	public ConfiguracaoBiblioteca(String configuracao){
		assert(configuracao != null);
		
		String[] configuracoesSeparadas = configuracao.split(";");
		
		this.nome = new NomeBiblioteca(configuracoesSeparadas[0]);
	}
	
	public TipoNomeBiblioteca obterNomeBiblioteca(){
		return nome;
	}
}

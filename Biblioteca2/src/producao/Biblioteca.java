package producao;

public class Biblioteca {

	private TipoConfiguracaoBiblioteca configuracao;

	public Biblioteca(TipoConfiguracaoBiblioteca configuração) {
		this.configuracao = configuração;
	}
	
	public TipoNomeBiblioteca obterNome(){
		return configuracao.obterNomeBiblioteca();
	}

	public int tamanho() {
		return 0;
	}
}

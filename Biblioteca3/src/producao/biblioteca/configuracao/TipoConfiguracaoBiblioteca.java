package producao.biblioteca.configuracao;

import producao.biblioteca.nome.TipoNomeBiblioteca;

public interface TipoConfiguracaoBiblioteca {
	public TipoNomeBiblioteca obterNomeBiblioteca();
	
	public int obterPrazoDevolucao();
}

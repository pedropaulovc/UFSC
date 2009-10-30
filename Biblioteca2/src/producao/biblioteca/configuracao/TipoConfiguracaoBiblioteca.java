package producao.biblioteca.configuracao;

import producao.dados.nome.TipoNome;

public interface TipoConfiguracaoBiblioteca {
	public TipoNome obterNomeBiblioteca();
	
	public int obterPrazoDevolucaoInteiro();
}

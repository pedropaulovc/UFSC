package producao.biblioteca.configuracao;

import producao.biblioteca.nome.TipoNomeBiblioteca;
import producao.livro.exemplar.prazoDevolucao.TipoPrazoDevolucao;

public interface TipoConfiguracaoBiblioteca {
	public TipoNomeBiblioteca obterNomeBiblioteca();
	
	public TipoPrazoDevolucao obterPrazoDevolucao();
}

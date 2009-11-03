package producao.biblioteca.configuracao;

import producao.dados.nome.TipoNome;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;

public interface TipoConfiguracaoBiblioteca {
	public TipoNome obterNomeBiblioteca();

	public TipoPrazoDevolucao obterNovoPrazoDevolucao();
}

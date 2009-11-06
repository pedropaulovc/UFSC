package producao.xteca.configuracao;

import producao.dados.nome.TipoNome;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;

public interface TipoConfiguracaoXteca {
	public TipoNome obterNome();

	public TipoPrazoDevolucao obterNovoPrazoDevolucao();
}

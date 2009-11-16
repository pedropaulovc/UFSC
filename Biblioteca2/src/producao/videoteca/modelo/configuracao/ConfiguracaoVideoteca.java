package producao.videoteca.modelo.configuracao;

import producao.dados.nome.modelo.TipoNome;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.xteca.configuracao.ConfiguracaoXteca;

public class ConfiguracaoVideoteca extends ConfiguracaoXteca implements
		TipoConfiguracaoVideoteca {

	public ConfiguracaoVideoteca(TipoNome nome,
			TipoPrazoDevolucao prazoDevolucao) {
		super(nome, prazoDevolucao);
	}

}

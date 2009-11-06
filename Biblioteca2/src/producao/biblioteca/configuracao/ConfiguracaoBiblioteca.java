package producao.biblioteca.configuracao;

import producao.dados.nome.TipoNome;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.xteca.configuracao.ConfiguracaoXteca;

public class ConfiguracaoBiblioteca extends ConfiguracaoXteca implements TipoConfiguracaoBiblioteca {
	public ConfiguracaoBiblioteca(TipoNome nome, TipoPrazoDevolucao prazo) {
		super(nome, prazo);
	}
}

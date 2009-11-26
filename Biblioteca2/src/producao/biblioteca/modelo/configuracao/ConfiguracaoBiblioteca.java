package producao.biblioteca.modelo.configuracao;

import producao.dados.nome.modelo.TipoNome;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;
import producao.xteca.configuracao.ConfiguracaoXteca;

public class ConfiguracaoBiblioteca extends ConfiguracaoXteca {
	public ConfiguracaoBiblioteca(TipoNome nome, TipoPrazoDevolucao prazo) {
		super(nome, prazo);
	}
}

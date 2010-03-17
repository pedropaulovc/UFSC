package producao.xteca.configuracao;

import producao.dados.nome.modelo.TipoNome;
import producao.dados.prazoDevolucao.PrazoDevolucao;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;

public class ConfiguracaoXteca {
	private TipoNome nome;
	private int prazoDevolucao;

	public ConfiguracaoXteca(TipoNome nome, TipoPrazoDevolucao prazo) {
		this.nome = nome;
		this.prazoDevolucao = prazo.obterPrazoInteiro();
	}

	public TipoNome obterNome() {
		return nome;
	}

	public TipoPrazoDevolucao obterNovoPrazoDevolucao() {
		return new PrazoDevolucao(prazoDevolucao);
	}
}

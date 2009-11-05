package producao.biblioteca.configuracao;

import producao.dados.nome.TipoNome;
import producao.dados.prazoDevolucao.PrazoDevolucao;
import producao.dados.prazoDevolucao.TipoPrazoDevolucao;

public class ConfiguracaoBiblioteca implements TipoConfiguracaoBiblioteca {
	private TipoNome nome;
	private int prazoDevolucao;

	public ConfiguracaoBiblioteca(TipoNome nome, TipoPrazoDevolucao prazo) {
		this.nome = nome;
		this.prazoDevolucao = prazo.obterPrazoInteiro();
	}

	public TipoNome obterNomeBiblioteca() {
		return nome;
	}

	public TipoPrazoDevolucao obterNovoPrazoDevolucao() {
		return new PrazoDevolucao(prazoDevolucao);
	}
}

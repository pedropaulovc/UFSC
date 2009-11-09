package producao.dados.prazoDevolucao;

import producao.dados.TipoDados;

public interface TipoPrazoDevolucao extends TipoDados {
	public boolean estaNoPrazo();

	public int obterPrazoDevolucaoRelativoAHoje();

	public int obterPrazoInteiro();

}

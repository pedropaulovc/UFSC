package producao.dados.prazoDevolucao;

public class PrazoDevolucaoNulo implements TipoPrazoDevolucao {

	public boolean estaNoPrazo() {
		return true;
	}

	public int obterPrazoDevolucaoRelativoAHoje() {
		return 0;
	}

	public int obterPrazoInteiro() {
		return 0;
	}

}

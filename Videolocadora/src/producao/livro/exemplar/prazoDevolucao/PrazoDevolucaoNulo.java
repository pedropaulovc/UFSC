package producao.livro.exemplar.prazoDevolucao;

public class PrazoDevolucaoNulo implements TipoPrazoDevolucao {

	public boolean estaNoPrazo() {
		return true;
	}

	public int obterPrazoDevolucaoRelativoAHoje() {
		return 0;
	}

}

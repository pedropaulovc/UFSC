package producao.dados.prazoDevolucao;

public interface TipoPrazoDevolucao {
	public boolean estaNoPrazo();
	
	public int obterPrazoDevolucaoRelativoAHoje();

	public int obterPrazoInteiro();

}

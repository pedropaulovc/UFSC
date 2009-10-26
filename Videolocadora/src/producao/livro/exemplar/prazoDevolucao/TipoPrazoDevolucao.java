package producao.livro.exemplar.prazoDevolucao;

public interface TipoPrazoDevolucao {
	public boolean estaNoPrazo();
	
	public int obterPrazoDevolucaoRelativoAHoje();

}

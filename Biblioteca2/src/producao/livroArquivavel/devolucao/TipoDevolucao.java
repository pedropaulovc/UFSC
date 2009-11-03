package producao.livroArquivavel.devolucao;

import producao.livroArquivavel.multa.TipoMulta;

public interface TipoDevolucao {
	public TipoMulta obterMulta();

	public boolean possuiMulta();
}

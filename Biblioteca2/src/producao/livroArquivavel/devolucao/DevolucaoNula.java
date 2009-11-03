package producao.livroArquivavel.devolucao;

import producao.livroArquivavel.multa.MultaNula;
import producao.livroArquivavel.multa.TipoMulta;


public class DevolucaoNula implements TipoDevolucao {
	public TipoMulta obterMulta() {
		return new MultaNula();
	}

	@Override
	public boolean possuiMulta() {
		return false;
	}

}

package producao.livroArquivavel.devolucao;

import producao.livroArquivavel.multa.MultaNula;
import producao.livroArquivavel.multa.TipoMulta;

public class Devolucao implements TipoDevolucao {
	private TipoMulta multa;
	private boolean possuiMulta;

	public Devolucao() {
		this.possuiMulta = false;
		this.multa = new MultaNula();
	}

	public Devolucao(TipoMulta multa) {
		this.possuiMulta = true;
		this.multa = multa;
	}

	public TipoMulta obterMulta() {
		return multa;
	}

	public boolean possuiMulta() {
		return possuiMulta;
	}
}

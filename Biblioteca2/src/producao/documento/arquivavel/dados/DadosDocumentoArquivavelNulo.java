package producao.documento.arquivavel.dados;

import producao.dados.numeroChamada.modelo.NumeroChamadaNulo;
import producao.dados.numeroChamada.modelo.TipoNumeroChamada;

public class DadosDocumentoArquivavelNulo implements
		TipoDadosDocumentoArquivavel {

	public TipoNumeroChamada obterNumeroChamada() {
		return new NumeroChamadaNulo();
	}

}

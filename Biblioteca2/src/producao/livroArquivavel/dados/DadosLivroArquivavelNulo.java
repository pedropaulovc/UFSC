package producao.livroArquivavel.dados;

import producao.dados.numeroChamada.NumeroChamadaNulo;
import producao.dados.numeroChamada.TipoNumeroChamada;

public class DadosLivroArquivavelNulo implements TipoDadosLivroArquivavel {

	@Override
	public TipoNumeroChamada obterNumeroChamada() {
		return new NumeroChamadaNulo();
	}

}

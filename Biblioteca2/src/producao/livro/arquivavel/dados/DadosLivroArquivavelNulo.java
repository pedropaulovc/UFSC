package producao.livro.arquivavel.dados;

import producao.dados.numeroChamada.modelo.NumeroChamadaNulo;
import producao.dados.numeroChamada.modelo.TipoNumeroChamada;

public class DadosLivroArquivavelNulo implements TipoDadosLivroArquivavel {

	public TipoNumeroChamada obterNumeroChamada() {
		return new NumeroChamadaNulo();
	}

}

package producao.biblioteca;

import producao.livro.TipoDadosLivroArquivavel;
import producao.livro.exemplar.numeroChamada.TipoNumeroChamada;

public class DadosLivroArquivavelNulo implements TipoDadosLivroArquivavel {

	@Override
	public TipoNumeroChamada obterNumeroChamada() {
		return new NumeroChamadaNulo();
	}

}

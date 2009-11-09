package producao.livro.arquivavel.dados;

import producao.dados.numeroChamada.modelo.TipoNumeroChamada;
import producao.documento.arquivavel.dados.DadosDocumentoArquivavel;

public class DadosLivroArquivavel extends DadosDocumentoArquivavel implements
		TipoDadosLivroArquivavel {

	public DadosLivroArquivavel(TipoNumeroChamada numeroChamada) {
		super(numeroChamada);
	}

}

package producao.livro.arquivavel.dados;

import producao.dados.numeroChamada.modelo.TipoNumeroChamada;
import producao.documento.arquivavel.dados.TipoDadosDocumentoArquivavel;

public interface TipoDadosLivroArquivavel extends TipoDadosDocumentoArquivavel {
	public TipoNumeroChamada obterNumeroChamada();
}

package producao.livro.arquivavel;

import producao.dados.numeroChamada.modelo.TipoNumeroChamada;
import producao.documento.arquivavel.TipoDocumentoArquivavel;
import producao.livro.TipoLivro;

public interface TipoLivroArquivavel extends TipoLivro, TipoDocumentoArquivavel {
	public TipoNumeroChamada obterNumeroChamada();

	public TipoLivro obterLivro();
}

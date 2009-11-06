package producao.livro.arquivavel;

import producao.dados.numeroChamada.TipoNumeroChamada;
import producao.livro.TipoLivro;

public interface TipoLivroArquivavel extends TipoLivro {
	public TipoNumeroChamada obterNumeroChamada();

	public TipoLivro obterLivro();
}

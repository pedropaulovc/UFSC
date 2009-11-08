package producao.livro.arquivavel;

import producao.dados.numeroChamada.modelo.TipoNumeroChamada;
import producao.livro.TipoLivro;

public interface TipoLivroArquivavel extends TipoLivro {
	public TipoNumeroChamada obterNumeroChamada();

	public TipoLivro obterLivro();
}

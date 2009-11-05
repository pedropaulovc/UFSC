package producao.biblioteca;

import producao.dados.id.TipoId;
import producao.livro.TipoLivro;
import producao.xteca.TipoXteca;

public interface TipoBiblioteca extends TipoXteca {
	public TipoId adicionar(TipoLivro documento);

	public TipoLivro obterDocumento(TipoId idDocumento);
}
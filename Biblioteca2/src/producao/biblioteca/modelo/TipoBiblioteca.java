package producao.biblioteca.modelo;

import producao.dados.id.TipoId;
import producao.livro.TipoLivro;
import producao.livro.arquivavel.dados.TipoDadosLivroArquivavel;
import producao.xteca.TipoXteca;

public interface TipoBiblioteca extends TipoXteca {
	public TipoId adicionarLivro(TipoLivro livro);
	
	public TipoId adicionarLivro(TipoLivro livro,
			TipoDadosLivroArquivavel dados);

	public TipoLivro obterLivro(TipoId idLivro);
	
	public TipoDadosLivroArquivavel obterDadosDeArquivo(TipoId idDoc);
}
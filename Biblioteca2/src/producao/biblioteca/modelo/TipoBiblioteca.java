package producao.biblioteca.modelo;

import producao.dados.id.TipoId;
import producao.livro.TipoLivro;
import producao.livro.arquivavel.dados.TipoDadosLivroArquivavel;
import producao.xteca.TipoXteca;

public interface TipoBiblioteca extends TipoXteca {
	public TipoId adicionar(TipoLivro livro);
	
	public TipoId adicionar(TipoLivro livro,
			TipoDadosLivroArquivavel dados);

	public TipoLivro obter(TipoId idLivro);
	
	public TipoDadosLivroArquivavel obterDadosDeArquivo(TipoId idDoc);
}
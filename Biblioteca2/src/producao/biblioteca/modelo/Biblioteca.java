package producao.biblioteca.modelo;

import producao.biblioteca.configuracao.TipoConfiguracaoBiblioteca;
import producao.dados.id.TipoId;
import producao.livro.LivroNulo;
import producao.livro.TipoLivro;
import producao.livro.arquivavel.LivroArquivavel;
import producao.xteca.Xteca;

public class Biblioteca extends Xteca implements TipoBiblioteca {

	public Biblioteca(TipoConfiguracaoBiblioteca configuração) {
		super(configuração);
	}

	public TipoId adicionarLivro(TipoLivro livro) {
		return adicionarDocumento(new LivroArquivavel(livro));
	}

	public TipoLivro obterLivro(TipoId idLivro) {
		try {
			return (TipoLivro) obterDocumento(idLivro);
		} catch (ClassCastException e) {
			return new LivroNulo();
		}
	}

}

package producao.biblioteca.modelo;

import producao.biblioteca.configuracao.TipoConfiguracaoBiblioteca;
import producao.dados.id.TipoId;
import producao.livro.LivroNulo;
import producao.livro.TipoLivro;
import producao.livro.arquivavel.LivroArquivavel;
import producao.livro.arquivavel.dados.TipoDadosLivroArquivavel;
import producao.xteca.Xteca;

public class Biblioteca extends Xteca implements TipoBiblioteca {

	public Biblioteca(TipoConfiguracaoBiblioteca configuração) {
		super(configuração);
	}

	public TipoId adicionar(TipoLivro livro) {
		return adicionarDocumento(new LivroArquivavel(livro));
	}

	public TipoId adicionar(TipoLivro livro, TipoDadosLivroArquivavel dados) {
		return adicionarDocumento(new LivroArquivavel(livro, dados));
	}

	public TipoLivro obter(TipoId idLivro) {
		try {
			return (TipoLivro) obterDocumento(idLivro);
		} catch (ClassCastException e) {
			return new LivroNulo();
		}
	}

	public TipoDadosLivroArquivavel obterDadosDeArquivo(TipoId idLivro) {
		return (TipoDadosLivroArquivavel) super.obterDadosDeArquivo(idLivro);
	}
}

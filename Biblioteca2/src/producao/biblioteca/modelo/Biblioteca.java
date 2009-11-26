package producao.biblioteca.modelo;

import producao.biblioteca.modelo.configuracao.ConfiguracaoBiblioteca;
import producao.dados.id.TipoId;
import producao.livro.Livro;
import producao.livro.LivroNulo;
import producao.livro.TipoLivro;
import producao.livro.arquivavel.LivroArquivavel;
import producao.livro.arquivavel.dados.DadosLivroArquivavel;
import producao.livro.arquivavel.dados.TipoDadosLivroArquivavel;
import producao.xteca.Xteca;

public class Biblioteca extends Xteca {

	public Biblioteca(ConfiguracaoBiblioteca configuração) {
		super(configuração);
	}

	public TipoId adicionar(Livro livro) {
		return adicionarDocumento(new LivroArquivavel(livro));
	}

	public TipoId adicionar(Livro livro, DadosLivroArquivavel dados) {
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

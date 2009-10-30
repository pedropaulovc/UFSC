package producao.livro;

import producao.dados.anoPublicacao.AnoPublicacaoNulo;
import producao.dados.anoPublicacao.TipoAnoPublicacao;
import producao.dados.autor.AutorNulo;
import producao.dados.autor.TipoAutor;
import producao.dados.nomeEditora.NomeEditoraNulo;
import producao.dados.nomeEditora.TipoNomeEditora;
import producao.dados.titulo.TipoTitulo;
import producao.dados.titulo.TituloNulo;
import producao.livro.dados.DadosLivroNulo;
import producao.livro.dados.TipoDadosLivro;

public class LivroNulo implements TipoLivro {

	public TipoAnoPublicacao obterAnoPublicacao() {
		return new AnoPublicacaoNulo();
	}

	public TipoAutor obterAutor() {
		return new AutorNulo();
	}

	public TipoDadosLivro obterDados() {
		return new DadosLivroNulo();
	}

	public TipoNomeEditora obterNomeEditora() {
		return new NomeEditoraNulo();
	}

	public TipoTitulo obterTitulo() {
		return new TituloNulo();
	}

}

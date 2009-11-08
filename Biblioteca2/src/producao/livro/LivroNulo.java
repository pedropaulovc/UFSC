package producao.livro;

import producao.dados.anoPublicacao.modelo.AnoPublicacaoNulo;
import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.autor.modelo.AutorNulo;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nomeEditora.modelo.NomeEditoraNulo;
import producao.dados.nomeEditora.modelo.TipoNomeEditora;
import producao.dados.titulo.modelo.TipoTitulo;
import producao.dados.titulo.modelo.TituloNulo;
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

package producao.livro.dados;

import producao.dados.anoPublicacao.AnoPublicacaoNulo;
import producao.dados.anoPublicacao.TipoAnoPublicacao;
import producao.dados.autor.AutorNulo;
import producao.dados.autor.TipoAutor;
import producao.dados.nomeEditora.NomeEditoraNulo;
import producao.dados.nomeEditora.TipoNomeEditora;
import producao.dados.titulo.TipoTitulo;
import producao.dados.titulo.TituloNulo;

public class DadosLivroNulo implements TipoDadosLivro {

	public TipoAnoPublicacao obterAnoPublicacao() {
		return new AnoPublicacaoNulo();
	}

	public TipoAutor obterAutor() {
		return new AutorNulo();
	}

	public TipoNomeEditora obterEditora() {
		return new NomeEditoraNulo();
	}

	public TipoTitulo obterTitulo() {
		return new TituloNulo();
	}

}

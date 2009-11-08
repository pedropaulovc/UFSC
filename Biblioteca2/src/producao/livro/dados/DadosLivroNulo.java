package producao.livro.dados;

import producao.dados.anoPublicacao.modelo.AnoPublicacaoNulo;
import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.autor.modelo.AutorNulo;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nomeEditora.modelo.NomeEditoraNulo;
import producao.dados.nomeEditora.modelo.TipoNomeEditora;
import producao.dados.titulo.modelo.TipoTitulo;
import producao.dados.titulo.modelo.TituloNulo;

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

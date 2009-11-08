package producao.livro;

import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nomeEditora.TipoNomeEditora;
import producao.dados.titulo.modelo.TipoTitulo;
import producao.livro.dados.TipoDadosLivro;

public class Livro implements TipoLivro {

	private TipoDadosLivro dados;

	public Livro(TipoDadosLivro dados) {
		this.dados = dados;
	}

	public TipoAutor obterAutor() {
		return dados.obterAutor();
	}

	public TipoTitulo obterTitulo() {
		return dados.obterTitulo();
	}

	public TipoDadosLivro obterDados() {
		return dados;
	}

	public TipoAnoPublicacao obterAnoPublicacao() {
		return dados.obterAnoPublicacao();
	}

	@Override
	public TipoNomeEditora obterNomeEditora() {
		return dados.obterEditora();
	}
}

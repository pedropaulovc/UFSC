package producao.livro.dados;

import producao.dados.anoPublicacao.modelo.AnoPublicacaoNulo;
import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.autor.modelo.AutorNulo;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nome.modelo.NomeNulo;
import producao.dados.nome.modelo.TipoNome;

public class DadosLivroNulo implements TipoDadosLivro {

	public TipoAnoPublicacao obterAnoPublicacao() {
		return new AnoPublicacaoNulo();
	}

	public TipoAutor obterAutor() {
		return new AutorNulo();
	}

	public TipoNome obterEditora() {
		return new NomeNulo();
	}

	public TipoNome obterTitulo() {
		return new NomeNulo();
	}

}

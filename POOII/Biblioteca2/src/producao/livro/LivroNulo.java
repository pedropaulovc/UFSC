package producao.livro;

import producao.dados.anoPublicacao.modelo.AnoPublicacaoNulo;
import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.autor.modelo.AutorNulo;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nome.modelo.NomeNulo;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.DocumentoNulo;
import producao.livro.dados.DadosLivroNulo;
import producao.livro.dados.TipoDadosLivro;

public class LivroNulo extends DocumentoNulo implements TipoLivro {

	public TipoAnoPublicacao obterAnoPublicacao() {
		return new AnoPublicacaoNulo();
	}

	public TipoAutor obterAutor() {
		return new AutorNulo();
	}

	public TipoDadosLivro obterDados() {
		return new DadosLivroNulo();
	}

	public TipoNome obterNomeEditora() {
		return new NomeNulo();
	}

}

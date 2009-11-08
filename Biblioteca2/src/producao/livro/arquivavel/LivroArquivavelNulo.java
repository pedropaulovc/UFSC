package producao.livro.arquivavel;

import producao.dados.anoPublicacao.modelo.AnoPublicacaoNulo;
import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.autor.modelo.AutorNulo;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nomeEditora.modelo.NomeEditoraNulo;
import producao.dados.nomeEditora.modelo.TipoNomeEditora;
import producao.dados.numeroChamada.modelo.NumeroChamadaNulo;
import producao.dados.numeroChamada.modelo.TipoNumeroChamada;
import producao.dados.titulo.modelo.TipoTitulo;
import producao.dados.titulo.modelo.TituloNulo;
import producao.livro.LivroNulo;
import producao.livro.TipoLivro;
import producao.livro.dados.DadosLivroNulo;
import producao.livro.dados.TipoDadosLivro;

public class LivroArquivavelNulo implements TipoLivroArquivavel {

	public TipoLivro obterLivro() {
		return new LivroNulo();
	}

	public TipoNumeroChamada obterNumeroChamada() {
		return new NumeroChamadaNulo();
	}

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

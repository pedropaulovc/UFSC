package producao.livro.arquivavel;

import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nome.modelo.TipoNome;
import producao.dados.numeroChamada.modelo.TipoNumeroChamada;
import producao.documento.arquivavel.DocumentoArquivavel;
import producao.livro.TipoLivro;
import producao.livro.arquivavel.dados.DadosLivroArquivavelNulo;
import producao.livro.arquivavel.dados.TipoDadosLivroArquivavel;
import producao.livro.dados.TipoDadosLivro;

public class LivroArquivavel extends DocumentoArquivavel implements
		TipoLivroArquivavel {

	private TipoDadosLivroArquivavel dados;
	private TipoLivro livro;

	public LivroArquivavel(TipoLivro livro, TipoDadosLivroArquivavel dados) {
		super(dados);
		this.livro = livro;
		this.dados = dados;
	}

	public LivroArquivavel(TipoLivro livro) {
		this(livro, new DadosLivroArquivavelNulo());
	}

	public TipoNumeroChamada obterNumeroChamada() {
		return dados.obterNumeroChamada();
	}

	public TipoLivro obterDocumento(){
		return livro;
	}
	
	public TipoAutor obterAutor() {
		return livro.obterAutor();
	}

	public TipoDadosLivro obterDados() {
		return livro.obterDados();
	}

	public TipoNome obterNomeEditora() {
		return livro.obterNomeEditora();
	}

	public TipoAnoPublicacao obterAnoPublicacao() {
		return livro.obterAnoPublicacao();
	}

	public TipoNome obterTitulo() {
		return livro.obterTitulo();
	}

}

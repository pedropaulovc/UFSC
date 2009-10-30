package producao.livro;

import producao.livro.autor.TipoAutor;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.exemplar.anoPublicacao.TipoAnoPublicacao;
import producao.livro.exemplar.nomeEditora.TipoNomeEditora;
import producao.livro.titulo.TipoTitulo;

public class Livro implements TipoLivro {

	private TipoDadosLivro dados;

	public Livro(TipoDadosLivro dados){
		this.dados = dados;
	}
	
	public TipoAutor obterAutor() {
		return dados.obterAutor();
	}

	public TipoTitulo obterTitulo() {
		return dados.obterTitulo();
	}
	
	public TipoDadosLivro obterDados(){
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

package producao.livro;

import producao.livro.autor.TipoAutor;
import producao.livro.dados.TipoDadosLivro;
import producao.livro.exemplar.anoPublicacao.TipoAnoPublicacao;
import producao.livro.exemplar.nomeEditora.TipoNomeEditora;
import producao.livro.titulo.TipoTitulo;

public interface TipoLivro {
	public TipoAutor obterAutor();

	public TipoTitulo obterTitulo();

	public TipoAnoPublicacao obterAnoPublicacao();
	
	public TipoNomeEditora obterNomeEditora();
	
	public TipoDadosLivro obterDados();
}

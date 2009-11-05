package producao.documento;

import producao.dados.anoPublicacao.TipoAnoPublicacao;
import producao.dados.autor.TipoAutor;
import producao.dados.nomeEditora.TipoNomeEditora;
import producao.dados.titulo.TipoTitulo;
import producao.livro.dados.TipoDadosLivro;

public interface TipoDocumento {
	public TipoAutor obterAutor();

	public TipoTitulo obterTitulo();

	public TipoAnoPublicacao obterAnoPublicacao();

	public TipoNomeEditora obterNomeEditora();

	public TipoDadosLivro obterDados();
}

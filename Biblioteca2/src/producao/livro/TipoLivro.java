package producao.livro;

import producao.dados.autor.TipoAutor;
import producao.dados.nomeEditora.TipoNomeEditora;
import producao.documento.TipoDocumento;
import producao.livro.dados.TipoDadosLivro;

public interface TipoLivro extends TipoDocumento {
	public TipoAutor obterAutor();

	public TipoNomeEditora obterNomeEditora();

	public TipoDadosLivro obterDados();

}

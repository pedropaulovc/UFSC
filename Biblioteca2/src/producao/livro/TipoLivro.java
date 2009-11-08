package producao.livro;

import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nomeEditora.modelo.TipoNomeEditora;
import producao.documento.TipoDocumento;
import producao.livro.dados.TipoDadosLivro;

public interface TipoLivro extends TipoDocumento {
	public TipoAutor obterAutor();

	public TipoNomeEditora obterNomeEditora();

	public TipoDadosLivro obterDados();

}

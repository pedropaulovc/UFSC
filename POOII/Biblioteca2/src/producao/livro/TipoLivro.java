package producao.livro;

import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.TipoDocumento;
import producao.livro.dados.TipoDadosLivro;

public interface TipoLivro extends TipoDocumento {
	public TipoAutor obterAutor();

	public TipoNome obterNomeEditora();

	public TipoDadosLivro obterDados();

}

package producao.livro.dados;

import producao.dados.autor.modelo.TipoAutor;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.dados.TipoDadosDocumento;

public interface TipoDadosLivro extends TipoDadosDocumento {
	public TipoAutor obterAutor();

	public TipoNome obterEditora();
}

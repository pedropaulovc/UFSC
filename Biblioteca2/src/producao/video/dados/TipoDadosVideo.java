package producao.video.dados;

import producao.dados.autor.modelo.TipoAutor;
import producao.dados.categoria.Categoria;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.dados.TipoDadosDocumento;

public interface TipoDadosVideo extends TipoDadosDocumento {
	public TipoAutor obterDiretor();

	public TipoNome obterNomeProdutora();

	public Categoria obterCategoria();
	
	public TipoNome obterEnredo();
}

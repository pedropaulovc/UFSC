package producao.video;

import producao.dados.autor.modelo.TipoAutor;
import producao.dados.categoria.Categoria;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.TipoDocumento;
import producao.video.dados.TipoDadosVideo;

public interface TipoVideo extends TipoDocumento {

	public TipoDadosVideo obterDados();

	public TipoAutor obterDiretor();

	public TipoNome obterNomeProdutora();

	public Categoria obterCategoria();

}

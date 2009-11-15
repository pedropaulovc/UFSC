package producao.video.dados;

import producao.dados.autor.modelo.TipoAutor;
import producao.dados.listaAtores.TipoListaAtores;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.dados.TipoDadosDocumento;

public interface TipoDadosVideo extends TipoDadosDocumento {
	public TipoAutor obterDiretor();

	public TipoListaAtores obterListaAtores();

	public TipoNome obterNomeProdutora();
}

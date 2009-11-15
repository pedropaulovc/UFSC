package producao.video.dados;

import producao.dados.autor.modelo.AutorNulo;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.listaAtores.ListaAtoresNula;
import producao.dados.listaAtores.TipoListaAtores;
import producao.dados.nome.modelo.NomeNulo;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.dados.DadosDocumentoNulo;

public class DadosVideoNulo extends DadosDocumentoNulo implements TipoDadosVideo {

	public TipoAutor obterDiretor() {
		return new AutorNulo();
	}

	public TipoListaAtores obterListaAtores() {
		return new ListaAtoresNula();
	}

	public TipoNome obterNomeProdutora() {
		return new NomeNulo();
	}
}

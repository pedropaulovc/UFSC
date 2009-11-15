package producao.video;

import producao.dados.autor.modelo.TipoAutor;
import producao.dados.listaAtores.TipoListaAtores;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.Documento;
import producao.video.dados.TipoDadosVideo;

public class Video extends Documento implements TipoVideo {

	private TipoDadosVideo dados;

	public Video(TipoDadosVideo dados) {
		super(dados);
		this.dados = dados;
	}

	public TipoAutor obterDiretor() {
		return dados.obterDiretor();
	}

	public TipoListaAtores obterListaAtores() {
		return dados.obterListaAtores();
	}

	public TipoNome obterNomeProdutora() {
		return dados.obterNomeProdutora();
	}

	public TipoDadosVideo obterDados() {
		return dados;
	}

}

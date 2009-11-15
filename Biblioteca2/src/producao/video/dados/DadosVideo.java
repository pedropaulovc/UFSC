package producao.video.dados;

import producao.dados.anoPublicacao.modelo.AnoPublicacao;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.listaAtores.TipoListaAtores;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.dados.DadosDocumento;

public class DadosVideo extends DadosDocumento implements TipoDadosVideo {

	private TipoAutor diretor;
	private TipoListaAtores listaAtores;
	private TipoNome nomeProdutora;

	public DadosVideo(TipoNome titulo, TipoAutor diretor,
			TipoListaAtores listaAtores, TipoNome nomeProdutora,
			AnoPublicacao anoPublicacao) {
		super(titulo, anoPublicacao);
		this.diretor = diretor;
		this.listaAtores = listaAtores;
		this.nomeProdutora = nomeProdutora;
	}

	public TipoAutor obterDiretor() {
		return diretor;
	}

	public TipoListaAtores obterListaAtores() {
		return listaAtores;
	}

	public TipoNome obterNomeProdutora() {
		return nomeProdutora;
	}

}

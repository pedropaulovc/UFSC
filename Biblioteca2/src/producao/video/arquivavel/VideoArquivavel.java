package producao.video.arquivavel;

import producao.dados.anoPublicacao.modelo.TipoAnoPublicacao;
import producao.dados.autor.modelo.TipoAutor;
import producao.dados.listaAtores.TipoListaAtores;
import producao.dados.nome.modelo.TipoNome;
import producao.documento.arquivavel.DocumentoArquivavel;
import producao.video.TipoVideo;
import producao.video.arquivavel.dados.DadosVideoArquivavelNulo;
import producao.video.arquivavel.dados.TipoDadosVideoArquivavel;
import producao.video.dados.TipoDadosVideo;

public class VideoArquivavel extends DocumentoArquivavel {

	private TipoVideo video;

	public VideoArquivavel(TipoVideo video, TipoDadosVideoArquivavel dados) {
		super(dados);
		this.video = video;
	}

	public VideoArquivavel(TipoVideo video) {
		this(video, new DadosVideoArquivavelNulo());
	}

	public TipoDadosVideo obterDados() {
		return video.obterDados();
	}

	public TipoAutor obterDiretor() {
		return video.obterDiretor();
	}

	public TipoListaAtores obterListaAtores() {
		return video.obterListaAtores();
	}

	public TipoNome obterNomeProdutora() {
		return video.obterNomeProdutora();
	}

	public TipoAnoPublicacao obterAnoPublicacao() {
		return video.obterAnoPublicacao();
	}

	public TipoNome obterTitulo() {
		return video.obterTitulo();
	}

	public TipoVideo obterDocumento() {
		return video;
	}
}

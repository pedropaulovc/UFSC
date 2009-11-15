package infra;

import java.util.ArrayList;
import java.util.List;

import producao.dados.anoPublicacao.modelo.AnoPublicacao;
import producao.dados.autor.modelo.Autor;
import producao.dados.listaAtores.ListaAtores;
import producao.dados.nome.modelo.Nome;
import producao.dados.nome.modelo.TipoNome;
import producao.dados.prazoDevolucao.PrazoDevolucao;
import producao.video.TipoVideo;
import producao.video.dados.DadosVideo;
import producao.video.dados.TipoDadosVideo;
import producao.video.produtora.Produtora;
import producao.video.produtora.TipoProdutora;
import producao.videoteca.TipoVideoteca;
import producao.videoteca.Videoteca;
import producao.videoteca.configuracao.ConfiguracaoVideoteca;
import producao.videoteca.configuracao.TipoConfiguracaoVideoteca;

public abstract class CenarioComVideoteca extends Cenario {
	private TipoProdutora produtora;
	private TipoDadosVideo dados;
	private TipoConfiguracaoVideoteca configVideoteca;

	public CenarioComVideoteca() {
		this.produtora = new Produtora();
		this.dados = new DadosVideo(new Nome("Titulo"), new Autor("Autor"),
				new ListaAtores(gerarAtores()), new Nome("Editora"),
				new AnoPublicacao(1999));
		this.configVideoteca = new ConfiguracaoVideoteca(new Nome(
				"Nome Videoteca"), new PrazoDevolucao(15));
	}

	public List<TipoNome> gerarAtores() {
		List<TipoNome> atores = new ArrayList<TipoNome>();
		atores.add(new Nome("Ator 1"));
		atores.add(new Nome("Ator 2"));

		return atores;
	}

	public TipoVideo obterVideo() {
		return produtora.criarVideo(dados);
	}

	public TipoVideoteca obterVideoteca() {
		return new Videoteca(configVideoteca);
	}

	public TipoProdutora obterProdutora() {
		return produtora;
	}
}

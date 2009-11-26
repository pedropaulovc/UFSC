package infra;

import static producao.dados.categoria.Categoria.ANIMAÇÃO;

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
import producao.videoteca.modelo.Videoteca;
import producao.videoteca.modelo.configuracao.ConfiguracaoVideoteca;

public abstract class CenarioComVideoteca extends Cenario {
	private Produtora produtora;
	private TipoDadosVideo dados;
	private ConfiguracaoVideoteca configVideoteca;

	public CenarioComVideoteca() {
		this.produtora = new Produtora();
		this.dados = new DadosVideo(new Nome("Titulo"), new Autor("Autor"),
				new ListaAtores(gerarAtores()), new Nome("Editora"),
				new AnoPublicacao(1999), ANIMAÇÃO);
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

	public Videoteca obterVideoteca() {
		return new Videoteca(configVideoteca);
	}

	public Produtora obterProdutora() {
		return produtora;
	}
}

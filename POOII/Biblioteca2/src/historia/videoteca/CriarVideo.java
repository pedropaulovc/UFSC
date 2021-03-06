package historia.videoteca;

import static org.junit.Assert.assertEquals;
import static producao.dados.categoria.Categoria.COMÉDIA;
import infra.CenarioComVideoteca;

import org.junit.Test;

import producao.dados.anoPublicacao.modelo.AnoPublicacao;
import producao.dados.autor.modelo.Autor;
import producao.dados.nome.modelo.Nome;
import producao.video.TipoVideo;
import producao.video.dados.DadosVideo;
import producao.video.dados.TipoDadosVideo;
import producao.video.produtora.Produtora;

public class CriarVideo extends CenarioComVideoteca {
	private TipoVideo video;
	private Produtora produtora;
	private TipoDadosVideo dados;

	public void dadoQue() {
		existeUmaProdutora();
		haDadosValidosDeUmVideo();
	}

	public void quando() {
		criarUmNovoVideoComOsDados();
	}

	public void então() {
		receboUmNovoVideoComOsMesmosDados();
	}

	private void existeUmaProdutora() {
		produtora = obterProdutora();
	}

	private void haDadosValidosDeUmVideo() {
		dados = new DadosVideo(new Nome("Titulo"), new Autor("Autor"),
				new Nome("Editora"), new AnoPublicacao(1999), COMÉDIA,
				new Nome("Um enredo"));
	}

	private void criarUmNovoVideoComOsDados() {
		video = produtora.criarVideo(dados);
	}

	@Test
	public void receboUmNovoVideoComOsMesmosDados() {
		assertEquals(dados, video.obterDados());
	}
}

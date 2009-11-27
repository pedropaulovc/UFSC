package producao.formulario;

import producao.dados.ExcecaoParametroInvalido;
import producao.dados.autor.modelo.Autor;
import producao.dados.categoria.Categoria;
import producao.dados.nome.modelo.Nome;
import producao.formulario.campos.CamposFormularioVideoteca;
import producao.video.Video;
import producao.video.arquivavel.TipoLancamento;
import producao.video.arquivavel.dados.DadosVideoArquivavel;
import producao.video.arquivavel.dados.TipoDadosVideoArquivavel;
import producao.video.dados.DadosVideo;
import producao.video.produtora.Produtora;
import producao.videoteca.visao.VisaoVideoteca;

public class AdaptadorFormularioVideoteca extends AdaptadorFormularioAbstrato {

	private CamposFormularioVideoteca campos;
	private Produtora produtora;

	public AdaptadorFormularioVideoteca(VisaoVideoteca visao) {
		super(visao.obterCamposFormulario());
		this.campos = visao.obterCamposFormulario();
		produtora = new Produtora();
	}

	public Video adaptarVideo() {
		return criarVideo();
	}

	public Video criarVideo() {
		DadosVideo dados = new DadosVideo(criarTitulo(), criarDiretor(),
				criarNomeProdutora(), criarAnoPublicacao(), criarCategoria(),
				criarEnredo());

		return produtora.criarVideo(dados);
	}

	private Categoria criarCategoria() {
		return Categoria.valueOf(campos.obterCategoria());
	}

	private TipoLancamento criarTipoLancamento() {
		return TipoLancamento.valueOf(campos.obterTipoLancamento());
	}
	
	private Autor criarDiretor() {
		try {
			return new Autor(campos.obterDiretor());
		} catch (ExcecaoParametroInvalido e) {
			notificarAlteracao("Campo Diretor vazio", this);
		}

		return null;
	}

	private Nome criarNomeProdutora() {
		try {
			return new Nome(campos.obterNomeProdutora());
		} catch (ExcecaoParametroInvalido e) {
			notificarAlteracao("Campo Nome da Produtora vazio", this);
		}

		return null;
	}

	private Nome criarEnredo() {
		try {
			return new Nome(campos.obterEnredo());
		} catch (ExcecaoParametroInvalido e) {
			notificarAlteracao("Campo Enredo vazio", this);
		}

		return null;
	}
	
	public boolean dadosDeArquivoPreenchidos(){
		return !campos.obterTipoLancamento().isEmpty();
	}

	public TipoDadosVideoArquivavel adaptarDadosDeArquivo() {
		return new DadosVideoArquivavel(criarTipoLancamento());
	}

}

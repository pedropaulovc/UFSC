package producao.videoteca.controle;

import producao.dados.autor.modelo.Autor;
import producao.dados.categoria.Categoria;
import producao.dados.nome.modelo.Nome;
import producao.formulario.AdaptadorFormularioAbstrato;
import producao.video.Video;
import producao.video.arquivavel.TipoLancamento;
import producao.video.arquivavel.dados.DadosVideoArquivavel;
import producao.video.arquivavel.dados.TipoDadosVideoArquivavel;
import producao.video.dados.DadosVideo;
import producao.video.produtora.Produtora;
import producao.videoteca.visao.CamposFormularioVideoteca;
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
		verificarCampos();

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
		return new Autor(campos.obterDiretor());
	}

	private Nome criarNomeProdutora() {
		return new Nome(campos.obterNomeProdutora());
	}

	private Nome criarEnredo() {
		return new Nome(campos.obterEnredo());
	}

	public boolean dadosDeArquivoPreenchidos() {
		return !campos.obterTipoLancamento().isEmpty();
	}

	public TipoDadosVideoArquivavel adaptarDadosDeArquivo() {
		return new DadosVideoArquivavel(criarTipoLancamento());
	}

	public void verificarCampos() {
		super.verificarCampos();

		if (!Autor.validar(campos.obterDiretor()))
			notificarAlteracao("Nome do Diretor inválido", this);

		if (!Nome.validar(campos.obterNomeProdutora()))
			notificarAlteracao("Nome da produtora inválido", this);

		if (!Nome.validar(campos.obterEnredo()))
			notificarAlteracao("Enredo inválido", this);
	}

}

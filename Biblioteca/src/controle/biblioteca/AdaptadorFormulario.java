package controle.biblioteca;

import modelo.biblioteca.Documento;
import modelo.biblioteca.Edicao;
import modelo.biblioteca.Exemplar;
import modelo.biblioteca.NumeroChamada;
import modelo.biblioteca.arquivaveis.Arquivavel;
import modelo.biblioteca.estadosEmprestimo.Situacao;
import visao.biblioteca.VisaoBiblioteca;
import visao.biblioteca.formulario.documento.CamposDocumento;
import visao.biblioteca.formulario.edicao.CamposEdicao;
import visao.biblioteca.formulario.exemplar.CamposExemplar;

public class AdaptadorFormulario {
	private CamposDocumento camposDocumento;
	private CamposEdicao camposEdicao;
	private CamposExemplar camposExemplar;

	public AdaptadorFormulario(VisaoBiblioteca visao) {
		this.camposDocumento = visao.obterFormulario().obterCamposDocumento();
		this.camposEdicao = visao.obterFormulario().obterCamposEdicao();
		this.camposExemplar = visao.obterFormulario().obterCamposExemplar();
	}

	public Documento adaptar() {
		return criarDocumento();
	}

	private Exemplar criarExemplar() {
		return new Exemplar(adaptarSituacao(), camposExemplar
				.obterLocalizacao());
	}

	private Edicao criarEdicao() {
		return new Edicao(criarExemplar(), criarNumeroChamada(),
				criarAnoPublicacao());
	}

	private Documento criarDocumento() {
		return new Documento(camposDocumento.obterTitulo(), camposDocumento
				.obterAutor(), adaptarArquivavel(), criarEdicao());
	}

	private int criarAnoPublicacao() {
		return AdaptadorDeString.converterParaInt(camposEdicao
				.obterAnoPublicacao());
	}

	private NumeroChamada criarNumeroChamada() {
		return new NumeroChamada(camposEdicao.obterNumeroChamada());
	}

	private Situacao adaptarSituacao() {
		String situacao = AdaptadorDeString
				.adaptarParaMaiusculasSemEspacos(camposExemplar
						.obterSituacao());
		return Enum.valueOf(Situacao.class, situacao);
	}

	private Arquivavel adaptarArquivavel() {
		String arquivavel = AdaptadorDeString
				.adaptarParaMaiusculasSemEspacos(camposDocumento
						.obterTipoDocumento());
		return Enum.valueOf(Arquivavel.class, arquivavel);
	}
}

package visao.biblioteca;

import java.util.ArrayList;
import java.util.List;

import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class FormularioBiblioteca {
	private PaginaDix pagina;
	private ComponenteDix botaoEnviar, tituloDocumento, autorDocumento,
			numeroChamada, numeroCapitulos, anoPublicacao, volume, localizacao,
			situacao, tipoDocumento, orientador;

	public FormularioBiblioteca(PaginaDix pagina) {
		this.pagina = pagina;
		montarFormulario();
	}

	private void montarFormulario() {
		criarCampoTitulo();
		criarCampoAutorDocumento();
		criarCampoNumeroChamada();
		criarCampoNumeroCapitulos();
		criarCampoAnoPublicacao();
		criarCampoVolume();
		criarCampoLocalizacao();
		criarListaEscolhaSituacao();
		criarListaEscolhaDocumento();
		criarCampoOrientador();
		criarBotaoEnviar();
	}

	private void criarCampoOrientador() {
		orientador = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "orientador");
		orientador.fixarTopo(370).fixarEsquerda(20).fixarLargura(500)
				.tornarInvisivel().fixarLegenda("Orientador");
	}

	private void criarBotaoEnviar() {
		botaoEnviar = pagina.criarComponente(TiposDeComponentesDix.BOTÃO,
				"botaoEnviar");
		botaoEnviar.fixarTopo(425).fixarEsquerda(200).fixarLargura(150)
				.fixarTexto("Enviar");
	}

	private void criarListaEscolhaDocumento() {
		List<String> listaDocumentos = new ArrayList<String>();
		listaDocumentos.add("Livro");
		listaDocumentos.add("Revista");
		listaDocumentos.add("TCC");
		listaDocumentos.add("Tese");
		listaDocumentos.add("Dissertação");

		tipoDocumento = pagina.criarComponente(
				TiposDeComponentesDix.LISTA_DE_ESCOLHA, "tipoDocumento");
		tipoDocumento.fixarTopo(320).fixarEsquerda(200).fixarLargura(150)
				.fixarLegenda("Tipo de Documento");
		tipoDocumento.fixarLista(listaDocumentos);
	}

	private void criarListaEscolhaSituacao() {
		List<String> listaOpcoes = new ArrayList<String>();
		listaOpcoes.add("Consulta Local");
		listaOpcoes.add("Disponível");
		listaOpcoes.add("Em Restauração");
		listaOpcoes.add("Emprestado");

		situacao = pagina.criarComponente(
				TiposDeComponentesDix.LISTA_DE_ESCOLHA, "situacao");
		situacao.fixarTopo(320).fixarEsquerda(20).fixarLargura(150)
				.fixarLegenda("Situação");
		situacao.fixarLista(listaOpcoes);
	}

	private void criarCampoLocalizacao() {
		localizacao = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "localizacao");
		localizacao.fixarTopo(270).fixarEsquerda(20).fixarLargura(500)
				.fixarLegenda("Localização Na Estante");
	}

	private void criarCampoVolume() {
		volume = pagina.criarComponente(TiposDeComponentesDix.CAMPO_DE_TEXTO,
				"volume");
		volume.fixarTopo(220).fixarEsquerda(150).fixarLargura(110)
				.fixarLegenda("Volume");
	}

	private void criarCampoAnoPublicacao() {
		anoPublicacao = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "anoPublicacao");
		anoPublicacao.fixarTopo(220).fixarEsquerda(280).fixarLargura(100)
				.fixarLegenda("Ano Publicação");
	}

	private void criarCampoNumeroCapitulos() {
		numeroCapitulos = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "numeroCapitulos");
		numeroCapitulos.fixarTopo(220).fixarEsquerda(410).fixarLargura(100)
				.fixarLegenda("Número Capítulos");
	}

	private void criarCampoNumeroChamada() {
		numeroChamada = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "numeroChamada");
		numeroChamada.fixarTopo(220).fixarEsquerda(20).fixarLargura(100)
				.fixarLegenda("Número Chamada");
	}

	private void criarCampoAutorDocumento() {
		autorDocumento = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "autorDocumento");
		autorDocumento.fixarTopo(170).fixarEsquerda(20).fixarLargura(500)
				.fixarLegenda("Autor");
	}

	private void criarCampoTitulo() {
		tituloDocumento = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "tituloDocumento");
		tituloDocumento.fixarTopo(120).fixarEsquerda(20).fixarLargura(500)
				.fixarLegenda("Título");
	}

	public void adicionarTratadorEventos(TratadorDixAbstrato tratador) {
		botaoEnviar.adicionarTratadorDeEventos(tratador);
	}

	public void adicionarTratadorTipoDocumento(TratadorDixAbstrato tratador) {
		tipoDocumento.adicionarTratadorDeEventos(tratador);
	}

	public String obterTitulo() {
		return tituloDocumento.obterTexto();
	}

	public String obterAutor() {
		return autorDocumento.obterTexto();
	}

	public String obterNumeroChamada() {
		return numeroChamada.obterTexto();
	}

	public String obterNumeroCapitulos() {
		return numeroCapitulos.obterTexto();
	}

	public String obterAnoPublicacao() {
		return anoPublicacao.obterTexto();
	}

	public String obterVolume() {
		return volume.obterTexto();
	}

	public String obterLocalizacao() {
		return localizacao.obterTexto();
	}

	public String obterSituacao() {
		return situacao.obterTexto();
	}

	public String obterTipoDocumento() {
		return tipoDocumento.obterTexto();
	}

	public void tornarInvisiveisCamposOpcionais() {
		numeroCapitulos.tornarInvisivel();
		orientador.tornarInvisivel();
	}

	public void tornarVisiveisCamposOpcionaisDeLivro() {
		numeroCapitulos.tornarVisivel();
	}

	public void tornarVisiveisCamposOpcionaisDeDissertacao() {
		orientador.tornarVisivel();
	}

	public FormularioBiblioteca clone() {
		try {
			return (FormularioBiblioteca) super.clone();
		} catch (CloneNotSupportedException excecao) {
			return this;
		}
	}

	public void tornarVisiveisCamposOpcionaisDeTese() {
		orientador.tornarVisivel();
	}

	public void tornarVisiveisCamposOpcionaisDeTCC() {
		orientador.tornarVisivel();
	}

	public void tornarVisiveisCamposOpcionaisDeRevista() {
	}
}

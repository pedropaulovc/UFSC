package visao;

import modelo.Citacao;
import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class VisaoDix extends Aplique {
	public PaginaDix pagina;
	public ComponenteDix qtdCitacoes, titulo, citacaoAleatoria,
			etiquetaAdicione, campoAdicione, gereCitacoes, botaoGereCitacoes, botaoAdicione;

	public VisaoDix(PaginaDix pagina) {
		this.pagina = pagina;

		mostrarTitulo();
		mostarQtdCitacoes();
		mostrarCitacaoAleatoria();
		mostrarAdicioneCitacao();
		mostrarGerarCitacoes();
	}

	private void mostrarGerarCitacoes() {
		gereCitacoes = pagina.criarComponente(TiposDeComponentesDix.ETIQUETA,
				"gereCitacoes");
		gereCitacoes.fixarTopo(40).fixarEsquerda(20).fixarTexto(
				"Utilize citações predefinidas: ");

		botaoGereCitacoes = pagina.criarComponente(TiposDeComponentesDix.BOTÃO,
				"botaoGereCitacoes");
		botaoGereCitacoes.fixarTopo(40).fixarEsquerda(200).fixarTexto("OK");
	}

	private void mostarQtdCitacoes() {
		qtdCitacoes = pagina.criarComponente(TiposDeComponentesDix.ETIQUETA,
				"qtdCitacoes");
		qtdCitacoes.fixarTopo(80).fixarEsquerda(20).fixarTexto(
				"Quantidade de citações: " + "0");
	}

	public void trocarQtdCitacoes(int qtd) {
		qtdCitacoes.fixarTexto("Quantidade de citações: " + qtd);
	}

	private void mostrarCitacaoAleatoria() {
		citacaoAleatoria = pagina.criarComponente(
				TiposDeComponentesDix.ETIQUETA, "citacaoAleatoria");
		citacaoAleatoria.fixarTopo(120).fixarEsquerda(20).fixarTexto(
				"Clique para gerar uma citação aleatória");
	}

	public void trocarCitacaoAleatoria(Citacao citacao) {
		citacaoAleatoria.fixarTexto("Clique para gerar uma citação aleatória: "
				+ citacao.toString());
	}

	private void mostrarTitulo() {
		titulo = pagina.criarComponente(TiposDeComponentesDix.ETIQUETA,
				"titulo");
		titulo.fixarTopo(20).fixarEsquerda(500).fixarTexto(
				"Citações Aleatórias");
	}

	private void mostrarAdicioneCitacao() {
		etiquetaAdicione = pagina.criarComponente(
				TiposDeComponentesDix.ETIQUETA, "etiquetaAdicione");
		etiquetaAdicione.fixarTopo(160).fixarEsquerda(20).fixarTexto(
				"Adicione uma citação: ");

		campoAdicione = pagina.criarComponente(
				TiposDeComponentesDix.CAMPO_DE_TEXTO, "campoAdicione");
		campoAdicione.fixarTopo(180).fixarEsquerda(20).fixarLargura(300);
		
		botaoAdicione = pagina.criarComponente(TiposDeComponentesDix.BOTÃO, "botaoAdicione");
		botaoAdicione.fixarTopo(180).fixarEsquerda(330).fixarTexto("OK");
	}

	public void log(String log) {
		System.out.println(log);
	}
}
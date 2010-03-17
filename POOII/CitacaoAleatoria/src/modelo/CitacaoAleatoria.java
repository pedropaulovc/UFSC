package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import visao.VisaoDix;

public class CitacaoAleatoria {
	private ListaCitacoes listaCitacoes;
	private VisaoDix visao;

	public CitacaoAleatoria(VisaoDix visao) {
		this.visao = visao;
		listaCitacoes = new ListaCitacoes();
	}

	public void gerarCitacoes(String arquivoFonte, String codificacao,
			String expressaoRegular) throws FileNotFoundException,
			UnsupportedEncodingException, IOException {

		new EstrategiaUtilizarCitacoesProntas().gerarCitacoes(arquivoFonte, codificacao,
				expressaoRegular, listaCitacoes);
		
		atualizar();
	}
	
	private void atualizar(){
		visao.trocarQtdCitacoes(qtdCitacoes());
		obterCitacaoAleatoria();
	}

	public void obterCitacaoAleatoria() {
		visao.trocarCitacaoAleatoria(listaCitacoes.obterCitacaoAleatoria().toString());
	}

	public Citacao obterCitacao(int num) {
		return listaCitacoes.obterCitacao(num);
	}

	public void adicionarCitacao(String citacao) {
		listaCitacoes.adicionarCitacao(new Citacao(citacao));
		visao.trocarQtdCitacoes(qtdCitacoes());
	}

	public int qtdCitacoes() {
		return listaCitacoes.qtdCitacoes();
	}

	public void log(String string) {
		visao.log(string);
	}
}
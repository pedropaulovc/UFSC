package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CitacaoAleatoria {
	private ListaCitacoes listaCitacoes;

	public CitacaoAleatoria() {
		listaCitacoes = new ListaCitacoes();
	}

	public void gerarCitacoes(String arquivoFonte, String codificacao,
			String expressaoRegular) throws FileNotFoundException,
			UnsupportedEncodingException, IOException {

		new Gerador().gerarCitacoes(arquivoFonte, codificacao,
				expressaoRegular, listaCitacoes);
	}

	public Citacao obterCitacaoAleatoria() {
		return listaCitacoes.obterCitacaoAleatoria();
	}

	public Citacao obterCitacao(int num) {
		return listaCitacoes.obterCitacao(num);
	}

	public void adicionarCitacao(Citacao citacao) {
		listaCitacoes.adicionarCitacao(citacao);
	}

	public int qtdCitacoes() {
		return listaCitacoes.qtdCitacoes();
	}
}
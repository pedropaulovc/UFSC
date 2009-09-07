package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class Analisador {
	public ListaCitacoes analisar(String arquivoFonte, String codificacao,
			String expressaoRegular) throws FileNotFoundException,
			UnsupportedEncodingException, IOException {

		String[] stringDividida = new Gerador(arquivoFonte, codificacao)
				.obterArquivo().split(expressaoRegular);
		ListaCitacoes lc = new ListaCitacoes();

		for (String sd : stringDividida) {
			lc.adicionarCitacao(new Citacao(sd));
		}

		return lc;
	}

}

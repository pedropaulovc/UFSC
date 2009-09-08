package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Gerador {
	public void gerarCitacoes(String arquivoFonte, String codificacao,
			String expressaoRegular, ListaCitacoes lc) throws FileNotFoundException,
			UnsupportedEncodingException, IOException {

		String[] stringDividida = new Baixador(arquivoFonte, codificacao)
				.obterArquivo().split(expressaoRegular);
		
		for (String sd : stringDividida) {
			lc.adicionarCitacao(new Citacao(sd));
		}
	}

}

package modeloAnalisador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import modelo.Citacao;
import modelo.ListaCitacoes;

public class Gerador {
	private String arquivo;
	private String codificacao;

	public Gerador(String arquivo, String codificacao) {
		this.arquivo = arquivo;
		this.codificacao = codificacao;
	}

	private String obterArquivo() throws FileNotFoundException,
			UnsupportedEncodingException, IOException {
		StringBuffer sb = new StringBuffer();

		Reader in = new BufferedReader(new InputStreamReader(
				new FileInputStream(new File(arquivo)), codificacao));

		int ch;
		while ((ch = in.read()) != -1) {
			sb.append((char) ch);
		}

		return sb.toString();
	}

	public ListaCitacoes gerar(String expressaoRegular)
			throws FileNotFoundException, UnsupportedEncodingException,
			IOException {
		
		String[] stringDividida = obterArquivo().split(expressaoRegular);
		ListaCitacoes lc = new ListaCitacoes();

		for (String sd : stringDividida) {
			lc.adicionarCitacao(new Citacao(sd));
		}
		
		return lc;
	}

}

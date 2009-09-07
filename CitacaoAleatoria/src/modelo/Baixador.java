package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class Baixador {
	private String caminhoArquivoFonte;
	private String codificacao;

	public Baixador(String caminhoArquivoFonte, String codificacao) {
		this.caminhoArquivoFonte = caminhoArquivoFonte;
		this.codificacao = codificacao;
	}

	public String obterArquivo() throws FileNotFoundException,
			UnsupportedEncodingException, IOException {
		StringBuffer sb = new StringBuffer();

		Reader in = new BufferedReader(new InputStreamReader(
				new FileInputStream(new File(caminhoArquivoFonte)), codificacao));

		int ch;
		while ((ch = in.read()) != -1) {
			sb.append((char) ch);
		}

		return sb.toString();
	}

}

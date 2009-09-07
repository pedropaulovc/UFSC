package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import modeloAnalisador.Analisador;

public class CitacaoAleatoria {
	public static void main(String[] args) {
		Analisador analisador = new Analisador();
		ListaCitacoes lc = new ListaCitacoes();
		lc.adicionarCitacao(new Citacao("Citacao Inválida"));
		try {
			lc = analisador.analisar("recursos/pfortune.txt", "UTF8", "\r\n%\r\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(lc.qtdCitacoes());
		for (int i = 0; i < lc.qtdCitacoes(); i++) {
			System.out.println(lc.obterCitacao(i).toString());
		}
	}
}
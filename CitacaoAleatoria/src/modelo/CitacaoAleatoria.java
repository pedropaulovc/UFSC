package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import modeloAnalisador.Gerador;

public class CitacaoAleatoria {
	public static void main(String[] args) {
		Gerador gerador = new Gerador("recursos/pfortune.txt", "UTF8");
		ListaCitacoes lc = new ListaCitacoes();
		lc.adicionarCitacao(new Citacao("Citacao Inválida"));
		try {
			lc = gerador.gerar("\r\n%\r\n");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(lc.qtdCitacoes());
		for (int i = 0; i < lc.qtdCitacoes(); i++) {
			System.out.println(lc.obterCitacao(i).toString());
		}
	}

	public static void obter(String[] args) {
		File file = new File("recursos/pfortune.txt");

		try {
			StringBuffer sb = new StringBuffer();
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, "UTF8");
			Reader in = new BufferedReader(isr);

			int ch;
			while ((ch = in.read()) != -1) {
				sb.append((char) ch);
			}
			System.out.println(sb);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void bufferedReader(String[] args) {
		File file = new File("recursos/pfortune.txt");

		System.out.println("extists " + file.exists());
		System.out.println(file.getAbsolutePath());
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while (br.readLine() != null) {
				System.out.print(br.readLine());
			}
			// System.out.println(sb);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void split(String[] args) {
		String string = "\"Vossas mensagens serão carinhosamente arquivadas no log \'/dev/null\'\"\n%\n\"Viva cada dia como se fosse o último; um dia, você acerta...\"\n%\n\"Um gato preto cruzando o seu caminho, significa que o animal está indo a algum lugar.\"\n%\n\"Vote no que promete menos. A decepção será menor.\"\n%\n";

		String[] splittedString = string.split("\n%\n");

		for (String ss : splittedString) {
			System.out.println(ss);
		}
	}

}
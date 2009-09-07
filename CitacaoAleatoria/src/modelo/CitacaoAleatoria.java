package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CitacaoAleatoria {
	private ListaCitacoes listaCitacoes;

	public static void main(String[] args) {
		CitacaoAleatoria ca = new CitacaoAleatoria();
		try {
			ca.gerarCitacoes("recursos/pfortune.txt", "UTF8", "\r\n%\r\n");
			System.out.println("qtd: " + ca.qtdCitacoes());
			for(int i = 0; i < ca.qtdCitacoes(); i++){
				System.out.println(ca.obterCitacao(i));
			}
			for(int i = 0; i < 10; i++){
				System.out.println("aleatória " + i + ": " + ca.obtercitacaoAleatoria());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public CitacaoAleatoria() {
		listaCitacoes = new ListaCitacoes();
	}

	public void gerarCitacoes(String arquivoFonte, String codificacao,
			String expressaoRegular) throws FileNotFoundException,
			UnsupportedEncodingException, IOException {

		listaCitacoes = new Gerador().gerarCitacoes(arquivoFonte, codificacao,
				expressaoRegular);
	}

	public Citacao obtercitacaoAleatoria() {
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

	public static void old(String[] args) {
		Gerador analisador = new Gerador();
		ListaCitacoes lc = new ListaCitacoes();
		lc.adicionarCitacao(new Citacao("Citacao Inválida"));
		try {
			lc = analisador.gerarCitacoes("recursos/pfortune.txt", "UTF8",
					"\r\n%\r\n");
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
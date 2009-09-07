package modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CitacaoAleatoria {
	private ListaCitacoes listaCitacoes;
	
	public CitacaoAleatoria(){
		//listaCitacoes = new ListaCitacoesNula();
	}
	
	public ListaCitacoes gerarCitacoes(String arquivoFonte, String codificacao,
			String expressaoRegular) throws FileNotFoundException,
			UnsupportedEncodingException, IOException {
		return new Gerador().gerarCitacoes(arquivoFonte, codificacao, expressaoRegular);
	}

	public Citacao escolherCitacaoAleatoria(ListaCitacoes lc){
		return lc.escolherCitacaoAleatoria();
	}
	
	
	public static void old(String[] args) {
		Gerador analisador = new Gerador();
		ListaCitacoes lc = new ListaCitacoes();
		lc.adicionarCitacao(new Citacao("Citacao Inválida"));
		try {
			lc = analisador.gerarCitacoes("recursos/pfortune.txt", "UTF8", "\r\n%\r\n");
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
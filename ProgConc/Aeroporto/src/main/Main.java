package main;

import objetos.Aviao;
import objetos.TorreControle;
import mensagem.CaixaPostal;

public class Main {
	public static void main(String[] args){
		int idTorre = 0;
		CaixaPostal caixas = new CaixaPostal(51);
		Aviao[] avioes = new Aviao[50];
		
		TorreControle torre = new TorreControle(caixas, idTorre);
		torre.start();
		
		for(int i = 1; i <= 50; i++){
			avioes[i - 1] = new Aviao(i, idTorre, caixas);
			avioes[i - 1].start();
		}
	}
}

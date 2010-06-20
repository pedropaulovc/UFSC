package main;

import objetos.Celular;
import objetos.EstacaoBase;
import objetos.NumCelular;

public class Main {
	public static void main(String[] args) {
		EstacaoBase[] estacoes = new EstacaoBase[2];
		Celular[] celulares = new Celular[20];

		for (int i = 0; i < estacoes.length; i++){
			estacoes[i] = new EstacaoBase(i + 1);
		}
		
		for (int i = 0; i < celulares.length; i++)
			celulares[i] = new Celular(new NumCelular(i + 1), estacoes[i % estacoes.length]);
		
		for(int i = 0; i < celulares.length; i++)
			celulares[i].start();
	}
}

package main;

import java.util.ArrayList;
import java.util.List;

import objetos.Celular;
import objetos.EstacaoBase;
import objetos.NumCelular;

public class Main {
	public static void main(String[] args) {
		int numCelulares = 20;
		int numEstacoes = 2;

		List<EstacaoBase> estacoes = new ArrayList<EstacaoBase>(numEstacoes);
		List<Celular> celulares = new ArrayList<Celular>(numCelulares);
		
		for (int i = 1; i <= numEstacoes; i++) {
			EstacaoBase estacao = new EstacaoBase(i);
			estacao.start();
			estacoes.add(estacao);
		}

		for (int i = 0; i < numCelulares; i++)
			celulares.add(new Celular(new NumCelular(i + 1), estacoes.get(i
					% numEstacoes)));

		for (int i = 0; i < numCelulares; i++)
			celulares.get(i).start();
	}
}

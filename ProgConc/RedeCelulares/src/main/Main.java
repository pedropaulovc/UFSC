package main;

import java.util.ArrayList;
import java.util.List;

import log.Log;
import mensagem.CaixaPostal;

import objetos.Celular;
import objetos.EstacaoBase;
import objetos.NumCelular;

public class Main {
	public static void main(String[] args) {
		int tempoSimulacao = -1;
		int numCelulares = 2;
		int numEstacoes = 1;
		Log.definirNivelDetalhes(2);
		NumCelular.definirFaixaNumeros(numCelulares, numEstacoes);

		CaixaPostal caixas = CaixaPostal.obterCaixa();
		for (int i = 0; i < (numCelulares + numEstacoes + 1); i++)
			caixas.gerarNovaCaixaPostal();

		List<EstacaoBase> estacoes = new ArrayList<EstacaoBase>(numEstacoes);
		List<Celular> celulares = new ArrayList<Celular>(numCelulares);

		for (int i = 1; i <= numEstacoes; i++) {
			EstacaoBase estacao = new EstacaoBase(i);
			estacao.start();
			estacoes.add(estacao);
		}

		for (int i = 1; i <= numCelulares; i++)
			celulares.add(new Celular(new NumCelular(numEstacoes + i), i
					% numEstacoes + 1));

		for (int i = 0; i < numCelulares; i++)
			celulares.get(i).start();
		
		if (tempoSimulacao > 0) {
			try {
				Thread.sleep(tempoSimulacao * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Log.adicionarLog("\nTempo de simulação: " + tempoSimulacao, 0);
			Log.exibirEstatísticas();

			System.exit(0);
		}

	}
}

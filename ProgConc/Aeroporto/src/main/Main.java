package main;

import log.Log;
import mensagem.CaixaPostal;
import mensagem.CodigosMensagem;
import mensagem.Mensagem;
import objetos.Aviao;
import objetos.TorreControle;

public class Main {
	public static void main(String[] args) {
		int numAvioes = 20;
		Log.definirNivelDetalhes(0);
		int idTorre = 0;
		CaixaPostal caixas = new CaixaPostal(numAvioes + 1);
		Aviao[] avioes = new Aviao[numAvioes];

		TorreControle torre = new TorreControle(caixas, idTorre);
		torre.start();

		for (int i = 1; i <= numAvioes; i++) {
			Aviao aviao = new Aviao(i, idTorre, caixas);
			avioes[i - 1] = aviao;
		}
		for (int i = 0; i < numAvioes; i++)
			avioes[i].start();

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mensagem msg = new Mensagem();
		msg.definirCodigo(CodigosMensagem.INICIAR_SISTEMA);
		caixas.send(idTorre, msg);
		caixas.send(idTorre, msg);
	}
}

package main;

import log.Log;
import mensagem.CaixaPostal;
import mensagem.CodigosMensagem;
import mensagem.Mensagem;
import objetos.Aviao;
import objetos.TorreControle;

public class Main {
	public static void main(String[] args){
		int numAvioes = 2; 
		Log.definirNivelDetalhes(1);
		int idTorre = 0;
		CaixaPostal caixas = new CaixaPostal(numAvioes + 1);
		Aviao[] avioes = new Aviao[numAvioes];
		
		TorreControle torre = new TorreControle(caixas, idTorre);
		torre.start();

		for(int i = 1; i <= numAvioes; i++){
			Aviao aviao = new Aviao(i, idTorre, caixas);
			avioes[i - 1] = aviao;			
		}
		for(int i = 0; i < numAvioes; i++)
			avioes[i].start();
		
		
		Mensagem msg = new Mensagem();
		msg.definirCodigo(CodigosMensagem.INICIAR_SISTEMA);
		caixas.send(idTorre,msg);

	}
}

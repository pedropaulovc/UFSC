package objetos;

import java.util.LinkedList;
import java.util.Queue;

import log.Log;
import mensagem.CaixaPostal;
import mensagem.Mensagem;
import static mensagem.CodigosMensagem.*;

public class TorreControle extends Thread {
	Pista[] pistas = new Pista[2];
	Queue<Integer> filaEsperaPouso = new LinkedList<Integer>();
	Queue<Integer> filaEsperaDecolagem = new LinkedList<Integer>();

	private CaixaPostal caixaPostal;
	private int pid;
	private boolean iniciou = false;

	public TorreControle(CaixaPostal caixa, int pid) {
		this.caixaPostal = caixa;
		this.pid = pid;
		for (int i = 0; i < 2; i++)
			pistas[i] = new Pista();
	}

	public void run() {
		while (true) {
			Mensagem msg = caixaPostal.receive(pid);
			Log.adicionarLog("Torre: recebeu mensagem " + msg.obterCodigo()	+ " de " + msg.obterId(), 1);
			switch (msg.obterCodigo()) {
			case REQUISICAO_POUSO:
				requisitarPouso(msg.obterId());
				break;
			case REQUISICAO_DECOLAGEM:
				requisitarDecolagem(msg.obterId());
				break;
			case OPERACAO_CONCLUIDA:
				Log.adicionarLog("Torre recebeu operação concluida do avião "+ msg.obterId(), 1);
				break;
			case INICIAR_SISTEMA:
				iniciou = true;
				break;
			}
			if(iniciou){
				atualizarPistas();
				Log.adicionarLog("Torre: terminou de atualizar as pistas", 1);
			}
		}
	}

	private void requisitarPouso(int idAviao) {
		filaEsperaPouso.add(idAviao);
	}

	private void requisitarDecolagem(int idAviao) {
		filaEsperaDecolagem.add(idAviao);
	}

	private void atualizarPistas() {
		int aviaoAutorizado;
		Mensagem msg = new Mensagem();
		msg.definirCodigo(OPERACAO_AUTORIZADA);

		for (int i = 0; i < 2; i++) {
			msg.definirPista(i);
			if (pistas[i].estaVazia()) {
				if (!filaEsperaPouso.isEmpty()) {
					pistas[i].tornarModoPouso();
					aviaoAutorizado = filaEsperaPouso.remove();
					caixaPostal.send(aviaoAutorizado, msg);
					Log.adicionarLog("Torre autorizou para pouso avião "+ aviaoAutorizado + " na pista " + i, 0);
				} else if (!filaEsperaDecolagem.isEmpty()) {
					pistas[i].tornarModoDecolagem();
					int j = 0;
					while (j < 3 && !filaEsperaDecolagem.isEmpty()) {
						aviaoAutorizado = filaEsperaDecolagem.remove();
						Log.adicionarLog("Avião " + aviaoAutorizado	+ " foi adicionado na fila de decolagem", 1);
						pistas[i].adicionarAviao(aviaoAutorizado);
						j++;
					}
				}
			}

			if (pistas[i].estaModoDecolagem() && !pistas[i].estaVazia()) {
				aviaoAutorizado = pistas[i].desenfileirarAviao();
				Log.adicionarLog("Torre autorizou para decolagem avião "+ aviaoAutorizado + " na pista " + i, 0);
				caixaPostal.send(aviaoAutorizado, msg);
			}
		}
	}

	public void adicionarAviao(Aviao aviao) {
		if (aviao.estaEmSolo())
			requisitarDecolagem(aviao.obterId());
		else
			requisitarPouso(aviao.obterId());
	}
}

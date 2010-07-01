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

	public TorreControle(CaixaPostal caixa, int pid) {
		this.caixaPostal = caixa;
		this.pid = pid;
		for (int i = 0; i < 2; i++)
			pistas[i] = new Pista();
	}

	public void run() {
		while (true) {
			atualizarPistas();
			Mensagem msg = caixaPostal.receive(pid);
			switch (msg.obterCodigo()) {
			case REQUISICAO_POUSO:
				requisitarPouso(msg.obterId());
				break;
			case REQUISICAO_DECOLAGEM:
				requsitarDecolagem(msg.obterId());
				break;
			case OPERACAO_CONCLUIDA:
				pistas[msg.obterPista()].desenfileirarAviao();
			default:
				break;
			}
		}
	}

	private void requisitarPouso(int idAviao) {
		filaEsperaPouso.add(idAviao);
	}

	private void requsitarDecolagem(int idAviao) {
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
					pistas[i].adicionarAviao(aviaoAutorizado);
					caixaPostal.send(aviaoAutorizado, msg);
					Log.adicionarLog("Torre autorizou para pouso avião " + aviaoAutorizado, 0);
				} else if (!filaEsperaDecolagem.isEmpty()) {
					pistas[i].tornarModoDecolagem();
					int j = 0;
					while (j < 3 && !filaEsperaDecolagem.isEmpty()) {
						aviaoAutorizado = filaEsperaDecolagem.remove();
						pistas[i].adicionarAviao(aviaoAutorizado);
						j++;
					}
				}
			}

			if (pistas[i].estaModoDecolagem() && !pistas[i].estaVazia()){
				aviaoAutorizado = pistas[i].obterPrimeiroDaFila();
				caixaPostal.send(aviaoAutorizado, msg);
				Log.adicionarLog("Torre autorizou para decolagem avião " + aviaoAutorizado, 0);	
			}
		}
	}
}

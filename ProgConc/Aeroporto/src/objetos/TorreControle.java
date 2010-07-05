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
	private int numAvioes;

	public TorreControle(CaixaPostal caixa, int pid, int numAvioes) {
		this.caixaPostal = caixa;
		this.pid = pid;
		for (int i = 0; i < 2; i++)
			pistas[i] = new Pista();
		this.numAvioes = numAvioes;
	}

	public void run() {
		Mensagem[] msgs = new Mensagem[2]; // Uma mensagem para cada pista
		int avioesCadastrados = 0;
		while (true) {
			dormir();
			for (int i = 0; i < 2; i++) {
				msgs[i] = new Mensagem();
				msgs[i].definirCodigo(TIMEOUT);
				if(caixaPostal.caixaCheia(pid))
					msgs[i] = caixaPostal.receive(pid);
				avioesCadastrados++;
				Log.adicionarLog(
						"Torre: recebeu mensagem " + i + " "
								+ msgs[i].obterCodigo() + " de "
								+ msgs[i].obterId(), 2);
				switch (msgs[i].obterCodigo()) {
				case REQUISICAO_POUSO:
					requisitarPouso(msgs[i].obterId());
					break;
				case REQUISICAO_DECOLAGEM:
					requisitarDecolagem(msgs[i].obterId());
					break;
				}
			}
			if (avioesCadastrados >= numAvioes) {
				atualizarPistas();
				Log.adicionarLog("Torre: terminou de atualizar as pistas", 1);
			}
			Log.adicionarLog("Estatísticas: ", 0);
			Log.adicionarLog("Aviões para pousar: " + filaEsperaPouso.size(), 0);
			Log.adicionarLog(
					"Aviões para decolar: " + filaEsperaDecolagem.size() + "\n",
					0);
		}
	}

	private void requisitarPouso(int idAviao) {
		Log.adicionarLog("Aeronave " + idAviao
				+ " requisitou autorização para POUSO", 0);
		filaEsperaPouso.add(idAviao);
	}

	private void requisitarDecolagem(int idAviao) {
		Log.adicionarLog("Aeronave " + idAviao
				+ " requisitou autorização para DECOLAGEM", 0);
		filaEsperaDecolagem.add(idAviao);
	}

	private void atualizarPistas() {
		int aviaoAutorizado;
		Mensagem msg = new Mensagem();
		msg.definirCodigo(OPERACAO_AUTORIZADA);

		for (int i = 0; i < 2; i++) {
			msg.definirPista(i);
			if (pistas[i].estaVazia()) {
				Log.adicionarLog("Pista " + i + " está vazia", 2);
				if (!filaEsperaPouso.isEmpty()) {
					pistas[i].tornarModoPouso();
					aviaoAutorizado = filaEsperaPouso.remove();
					caixaPostal.send(aviaoAutorizado, msg);
					Log.adicionarLog("Torre autorizou para POUSO avião "
							+ aviaoAutorizado + " na pista " + i, 0);
					Log.adicionarLog(
							"Pista " + i
									+ " sendo usada para POUSO. Aeronave: "
									+ aviaoAutorizado, 0);
				} else if (!filaEsperaDecolagem.isEmpty()) {
					pistas[i].tornarModoDecolagem();
					int j = 0;
					while (j < 3 && !filaEsperaDecolagem.isEmpty()) {
						aviaoAutorizado = filaEsperaDecolagem.remove();
						Log.adicionarLog("Avião " + aviaoAutorizado
								+ " foi adicionado na fila de decolagem", 1);
						pistas[i].adicionarAviao(aviaoAutorizado);
						j++;
					}
				}
			}

			if (pistas[i].estaModoDecolagem() && !pistas[i].estaVazia()) {
				aviaoAutorizado = pistas[i].desenfileirarAviao();
				Log.adicionarLog("Torre autorizou para DECOLAGEM avião "
						+ aviaoAutorizado + " na pista " + i, 0);
				Log.adicionarLog("Pista " + i
						+ " sendo usada para DECOLAGEM. Aeronaves: "
						+ pistas[i].toString() + aviaoAutorizado, 0);
				caixaPostal.send(aviaoAutorizado, msg);
			}
		}
	}
	
	private void dormir() {
		try {
			sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

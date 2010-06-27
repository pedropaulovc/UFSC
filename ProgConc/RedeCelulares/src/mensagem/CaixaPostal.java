package mensagem;

import log.Log;

public class CaixaPostal {
	Mensagem cxpostal;
	boolean cxcheia;

	public synchronized void send(Mensagem msg) {
		try {
			while (cxcheia)
				wait();
			cxcheia = true;
			cxpostal = msg;
			notify();
		} catch (Exception e) {
			Log.adicionarLog("Erro no envio de mensagem: " + e, 0);
		}
	}

	public synchronized Mensagem receive() {
		try {
			while (!cxcheia)
				wait();
			cxcheia = false;
			notify();
		} catch (Exception e) {
			Log.adicionarLog("Erro no recebimento de mensagem: " + e, 0);
		}
		return cxpostal;
	}
}

package mensagem;

import log.Log;
import static mensagem.CodigosMensagem.TIME_OUT;

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
			if (!cxcheia)
				wait(4*500);
			if(!cxcheia){ // deu timeout e a caixa ainda está vazia. Cria-se uma mensagem de TIMEOUT
				Mensagem msg = new Mensagem();
				msg.definirCodigo(TIME_OUT);
				return msg;
			}
			cxcheia = false;
			notify();
		} catch (Exception e) {
			Log.adicionarLog("Erro no recebimento de mensagem: " + e, 0);
		}
		return cxpostal;
	}
}

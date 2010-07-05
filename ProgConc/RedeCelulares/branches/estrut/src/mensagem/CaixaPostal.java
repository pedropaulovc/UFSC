package mensagem;

import log.Log;
import static mensagem.CodigosMensagem.TIME_OUT;

public class CaixaPostal {
	Mensagem cxpostal;
	boolean cxcheia;

	public synchronized boolean send(Mensagem msg) {
		try {
			if (cxcheia)
				wait(4*500);
			if (cxcheia){ //não conseguiu enviar a mensagem (timeout no envio). Gera uma mensagem de ocupado para o requerente
				return false;			
			}
			cxcheia = true;
			cxpostal = msg;
			notify();
		} catch (Exception e) {
			Log.adicionarLog("Erro no envio de mensagem: " + e, 0);
		}
		return true;
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

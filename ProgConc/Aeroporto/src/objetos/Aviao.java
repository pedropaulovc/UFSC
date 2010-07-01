package objetos;

import log.Log;
import mensagem.CaixaPostal;
import mensagem.CodigosMensagem;
import mensagem.Mensagem;
import static mensagem.CodigosMensagem.*;

public class Aviao extends Thread {
	private boolean emSolo = true;
	private int id;
	private int idTorre;
	private CaixaPostal caixaPostal;

	public Aviao(int id, int idTorre, CaixaPostal caixaPostal) {
		this.id = id;
		this.idTorre = idTorre;
		this.caixaPostal = caixaPostal;
	}

	public void run() {
		while (true) {
			Mensagem msg = new Mensagem();
			CodigosMensagem codigo;
			if (emSolo)
				codigo = REQUISICAO_DECOLAGEM;
			else
				codigo = REQUISICAO_POUSO;
			msg.definirCodigo(codigo);
			Log.adicionarLog("Avião " + id + " requisitou " + codigo, 0);
			caixaPostal.send(idTorre, msg);

			msg = caixaPostal.receive(id);
			switch (msg.obterCodigo()) {
			case OPERACAO_AUTORIZADA:
				Log.adicionarLog("Avião " + id + " terminou a operação", 0);
				emSolo = !emSolo;
				msg.definirCodigo(OPERACAO_CONCLUIDA);
				caixaPostal.send(idTorre, msg);
				break;
			}
		}
	}
}

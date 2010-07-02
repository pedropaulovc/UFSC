package objetos;

import java.util.Random;

import log.Log;
import mensagem.CaixaPostal;
import mensagem.CodigosMensagem;
import mensagem.Mensagem;
import static mensagem.CodigosMensagem.*;

public class Aviao extends Thread {
	private boolean emSolo;
	private int id;
	private int idTorre;
	private CaixaPostal caixaPostal;

	public Aviao(int id, int idTorre, CaixaPostal caixaPostal) {
		this.id = id;
		this.idTorre = idTorre;
		this.caixaPostal = caixaPostal;
		emSolo = new Random().nextBoolean();
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
			msg.definirId(id);
			caixaPostal.send(idTorre, msg);

			msg = caixaPostal.receive(id);
			switch (msg.obterCodigo()) {
			case OPERACAO_AUTORIZADA:
				Log.adicionarLog("Avião " + id + " foi autorizado", 0);
				emSolo = !emSolo;
//				msg.definirCodigo(OPERACAO_CONCLUIDA);
//				msg.definirId(id);
//				caixaPostal.send(idTorre, msg);
				break;
			}
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean estaEmSolo(){
		return emSolo;
	}

	public int obterId() {
		return id;
	}
}

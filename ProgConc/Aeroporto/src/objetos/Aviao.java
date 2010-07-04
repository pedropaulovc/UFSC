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
		
		if(emSolo)
			Log.adicionarLog("Avião " + id + " em solo", 0);
		else
			Log.adicionarLog("Avião " + id + " voando", 0);
	}

	public void run() {		
		while (true) {
			Mensagem msg = new Mensagem();
			CodigosMensagem codigo;
			if (emSolo){
				codigo = REQUISICAO_DECOLAGEM;
				dormir(0);
			}
			else{
				codigo = REQUISICAO_POUSO;
				dormir(new Random().nextInt(2300));
			}
			msg.definirCodigo(codigo);
			msg.definirId(id);
			caixaPostal.send(idTorre, msg);

			msg = caixaPostal.receive(id);
			switch (msg.obterCodigo()) {
			case OPERACAO_AUTORIZADA:
				Log.adicionarLog("Avião " + id + " foi autorizado", 1);
				emSolo = !emSolo;
//				msg.definirCodigo(OPERACAO_CONCLUIDA);
//				msg.definirId(id);
//				caixaPostal.send(idTorre, msg);
				break;
			}
			
		}
	}
	
	private void dormir(int tempo) {

		try {
			sleep(500+tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean estaEmSolo(){
		return emSolo;
	}

	public int obterId() {
		return id;
	}
}

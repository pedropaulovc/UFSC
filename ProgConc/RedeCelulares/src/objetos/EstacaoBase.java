package objetos;

import java.util.HashMap;
import java.util.Map;

import log.Log;
import mensagem.CaixaPostal;
import mensagem.Mensagem;
import static mensagem.CodigosMensagem.*;
import static estados.EstadoLigacao.*;
import static estados.EstadoCelular.*;

public class EstacaoBase extends Thread {
	private Map<NumCelular, Celular> celularesLocais = new HashMap<NumCelular, Celular>();
	private CaixaPostal caixaPostal = CaixaPostal.obterCaixa();
	private int idServidor;
	private int id;

	public EstacaoBase(int id, int idServidor) {
		this.id = id;
		this.idServidor = idServidor;
	}

	public void run() {
		while (true) {
			Mensagem msg = new Mensagem();
			msg.definirCodigo(TIMEOUT);
			if(caixaPostal.caixaCheia(id))
				msg = caixaPostal.receive(id);
			switch (msg.obterCodigo()) {
			case RECEBER_LIGACAO:
				fazerLigacao(msg);
				break;
			case CADASTRAR:
				cadastrarCelular(msg);
			default:
				break;
			}
		}
	}

	private void cadastrarCelular(Mensagem msg) {
		celularesLocais.put(msg.obterOrigem(), msg.obterCelular());		
	}

	private void fazerLigacao(Mensagem msg) {
		NumCelular numDestino = msg.obterDestino();
		NumCelular numOrigem = msg.obterOrigem();

		if (numOrigem.equals(numDestino)) {
			Mensagem msgErro = new Mensagem();
			msgErro.definirCodigo(RESPOSTA_LIGACAO);
			msgErro.definirEstadoLigacao(NUMERO_INVALIDO);
			caixaPostal.send(msg.obterId(), msgErro);
			return;
		}

		Log.adicionarLog("Torre " + id + " direcionando ligação de "
				+ numOrigem + " para " + numDestino, 0);

		msg.definirCodigo(RECEBER_LIGACAO);
		if (celularesLocais.containsKey(numDestino)) {
			caixaPostal.send(numDestino.obterNumero(), msg);
		} else {
			caixaPostal.send(idServidor, msg);
		}
	}
}

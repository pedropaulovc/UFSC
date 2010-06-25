package objetos;

import static estados.EstadoCelular.*;
import static estados.EstadoLigacao.*;
import static mensagem.CodigosMensagem.*;
import java.util.HashMap;
import java.util.Map;

import log.Log;
import mensagem.CaixaPostal;
import mensagem.CodigosMensagem;
import mensagem.Mensagem;
import estados.EstadoLigacao;

public class EstacaoBase extends Thread {
	private Map<NumCelular, Celular> celulares = new HashMap<NumCelular, Celular>();
	private CaixaPostal caixaPostal;
	private int numLigacoes = 10;
	private int id;

	public EstacaoBase(int id) {
		this.id = id;
		this.caixaPostal = new CaixaPostal();
	}

	public void run() {
		while (true) {
			Mensagem msg = caixaPostal.receive();
			switch (msg.obterCodigo()) {
			case ASSOCIAR_CELULAR:
				associarCelular(msg.obterCelular());
				break;
			case DESASSOCIAR_CELULAR:
				desassociarCelular(msg.obterCelular());
				break;
			case FAZER_LIGACAO:
				fazerLigacao(msg.obterCelular(), msg.obterNumero());
				break;
			case RECEBER_LIGACAO:
				receberLigacao(msg.obterNumero());
				break;
			case TERMINAR_LIGACAO:
				terminarLigacao(msg.obterNumero());
				break;
			}
		}
	}

	private void associarCelular(Celular celular) {
		Mensagem msg = new Mensagem();
		NumCelular numCelular = celular.obterNumero();

		msg.definirCodigo(ADICIONAR_CELULAR);
		msg.definirNumero(numCelular);
		msg.definirEstacao(this);

		celulares.put(numCelular, celular);
		ServidorCentral.send(msg);
	}

	private void desassociarCelular(Celular celular) {
		Mensagem msg = new Mensagem();
		NumCelular numCelular = celular.obterNumero();

		msg.definirCodigo(REMOVER_CELULAR);
		msg.definirNumero(numCelular);

		celulares.remove(numCelular);
		ServidorCentral.send(msg);
	}

	private void fazerLigacao(Celular origem, NumCelular numDestino) {
		Mensagem msg = new Mensagem();

		try {
			while (numLigacoes == 0)
				wait();
		} catch (InterruptedException e) {
			Log.adicionarLog(e.toString());
		}
		numLigacoes--;

		EstacaoBase estacaoDestino = buscarEstacao(numDestino);
		if (estacaoDestino == null) {
			msg.definirCodigo(RESULTADO_LIGACAO);
			msg.definirEstadoLigacao(NUMERO_INVALIDO);
			origem.send(msg);
			return;
		}

		msg.definirCodigo(RECEBER_LIGACAO);
		msg.definirEstacao(this);
		msg.definirNumero(numDestino);
		estacaoDestino.send(msg);
	}

	private EstacaoBase buscarEstacao(NumCelular numDestino) {
		EstacaoBase estacaoDestino = this;

		if (!celulares.containsKey(numDestino)) {
			Mensagem msg = new Mensagem();
			msg.definirCodigo(BUSCAR_ESTACAO);
			msg.definirNumero(numDestino);
			ServidorCentral.send(msg);
			msg = caixaPostal.receive();
			estacaoDestino = msg.obterEstacao();
		}
		return estacaoDestino;

	}

	private void receberLigacao(NumCelular numDestino) {
		assert (celulares.containsKey(numDestino));
		try {
			while (numLigacoes == 0)
				wait();
		} catch (InterruptedException e) {
			Log.adicionarLog(e.toString());
		}
		numLigacoes--;

		Celular celular = celulares.get(numDestino);

		Mensagem msg = new Mensagem();
		msg.definirCodigo(RECEBER_LIGACAO);
		//TODO: Pode ser interessante informar o celular destino de quem o chama.
		celular.send(msg);
	}

	private void terminarLigacao(NumCelular numDestino) {
		if (celulares.containsKey(numDestino)) {
			Celular celular = celulares.get(numDestino);
			if (celular.obterEstado() == EM_LIGACAO) {
				numLigacoes++;
				notify();
				return celular.terminarLigacao();
			}
			return TERMINADA;
		}
		EstacaoBase estacaoDestino = buscarEstacao(numDestino);
		if (estacaoDestino == null)
			return NUMERO_INVALIDO;

		return estacaoDestino.terminarLigacao(numDestino);
	}

	public int obterId() {
		return id;
	}

	public void send(Mensagem msg) {
		caixaPostal.send(msg);
	}
}

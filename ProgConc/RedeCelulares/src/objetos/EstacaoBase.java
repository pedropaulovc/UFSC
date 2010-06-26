package objetos;

import static estados.EstadoCelular.*;
import static estados.EstadoLigacao.*;
import static mensagem.CodigosMensagem.*;
import java.util.HashMap;
import java.util.Map;

import log.Log;
import mensagem.CaixaPostal;
import mensagem.Mensagem;

public class EstacaoBase extends Thread {
	private Map<NumCelular, Celular> listaCelulares = new HashMap<NumCelular, Celular>();
	private Map<NumCelular, Celular> bufferChamadas = new HashMap<NumCelular, Celular>();
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
			case REQUISITAR_LIGACAO:
				requisitarLigacao(msg.obterCelular(), msg.obterNumero());
				break;
			case CELULAR_LOCALIZADO:
				completarLigacao(msg.obterNumero(), msg.obterEstacao());
				break;
			case RECEBER_LIGACAO:
				receberLigacao(msg.obterNumero());
				break;
			case TERMINAR_LIGACAO:
				terminarLigacao(msg.obterNumero());
				break;
			case RESULTADO_LIGACAO:
				//TODO informarResultado(msg.obterEstadoLigacao());
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

		listaCelulares.put(numCelular, celular);
		ServidorCentral.send(msg);
	}

	private void desassociarCelular(Celular celular) {
		Mensagem msg = new Mensagem();
		NumCelular numCelular = celular.obterNumero();

		msg.definirCodigo(REMOVER_CELULAR);
		msg.definirNumero(numCelular);

		listaCelulares.remove(numCelular);
		ServidorCentral.send(msg);
	}

	private void requisitarLigacao(Celular origem, NumCelular numDestino) {
		try {
			while (numLigacoes == 0)
				wait();
		} catch (InterruptedException e) {
			Log.adicionarLog(e.toString());
		}
		numLigacoes--;
		
		bufferChamadas.put(numDestino, origem);
		
		if(!listaCelulares.containsKey(numDestino))
			buscarEstacao(numDestino);
		else
			completarLigacao(numDestino, this);
	}

	private void completarLigacao(NumCelular numDestino, EstacaoBase estacaoDestino) {
		Mensagem msg = new Mensagem();
		Celular origem = bufferChamadas.remove(numDestino);

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

	private void buscarEstacao(NumCelular numDestino) {
		Mensagem msg = new Mensagem();
		msg.definirCodigo(BUSCAR_ESTACAO);
		msg.definirNumero(numDestino);
		ServidorCentral.send(msg);
	}

	private void receberLigacao(NumCelular numDestino) {
		assert (listaCelulares.containsKey(numDestino));
		try {
			while (numLigacoes == 0)
				wait();
		} catch (InterruptedException e) {
			Log.adicionarLog(e.toString());
		}
		numLigacoes--;

		Celular celular = listaCelulares.get(numDestino);

		Mensagem msg = new Mensagem();
		msg.definirCodigo(RECEBER_LIGACAO);
		celular.send(msg);
	}

	private void terminarLigacao(NumCelular numDestino) {
		Mensagem msg = new Mensagem();
		if (listaCelulares.containsKey(numDestino)) {
			Celular celular = listaCelulares.get(numDestino);

			msg.definirCodigo(TERMINAR_LIGACAO);
			celular.send(msg);

			numLigacoes++;
			notify();
			return;
		}
		
		//TODO BuscarEstação
		
		msg.definirCodigo(TERMINAR_LIGACAO);
		msg.definirNumero(numDestino);

		// TODO estacaoDestino.send(msg);
	}

	public int obterId() {
		return id;
	}

	public void send(Mensagem msg) {
		caixaPostal.send(msg);
	}
}

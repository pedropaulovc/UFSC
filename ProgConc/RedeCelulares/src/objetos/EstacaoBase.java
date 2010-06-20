package objetos;

import java.util.HashMap;
import java.util.Map;

import log.Log;

import estados.EstadoLigacao;
import static estados.EstadoLigacao.*;
import static estados.EstadoCelular.*;

public class EstacaoBase extends Thread {
	private Map<NumCelular, Celular> celulares = new HashMap<NumCelular, Celular>();
	private int numLigacoes = 10;
	private int id;

	public EstacaoBase(int id){
		this.id = id;
	}
	
	public synchronized void associarCelular(Celular celular) {
		NumCelular numCelular = celular.obterNumero();

		celulares.put(numCelular, celular);
		ServidorCentral.adicionarCelular(numCelular, this);
	}

	public synchronized void desassociarCelular(Celular celular) {
		NumCelular numCelular = celular.obterNumero();

		celulares.remove(numCelular);
		ServidorCentral.removerCelular(numCelular);
	}

	public synchronized EstadoLigacao fazerLigacao(NumCelular numDestino) {
		try {
			while (numLigacoes == 0)
				wait();
		} catch (InterruptedException e) {
			Log.adicionarLog(e.toString());
		}
		numLigacoes--;

		EstacaoBase estacaoDestino = buscarEstacao(numDestino);
		if(estacaoDestino == null)
			return NUMERO_INVALIDO;

		return estacaoDestino.receberLigacao(numDestino);
	}

	private EstacaoBase buscarEstacao(NumCelular numDestino) {
		EstacaoBase estacaoDestino = this;
		if (!celulares.containsKey(numDestino)) {
			if (!ServidorCentral.celularCadastrado(numDestino))
				return null;
			estacaoDestino = ServidorCentral.buscarEstacao(numDestino);
		}
		return estacaoDestino;
	}

	public synchronized EstadoLigacao receberLigacao(NumCelular numDestino) {
		assert (celulares.containsKey(numDestino));
		try {
			while (numLigacoes == 0)
				wait();
		} catch (InterruptedException e) {
			Log.adicionarLog(e.toString());
		}
		numLigacoes--;

		Celular celular = celulares.get(numDestino);
		return celular.receberLigacao();
	}

	public synchronized EstadoLigacao terminarLigacao(NumCelular numDestino) {
		if(celulares.containsKey(numDestino)){
			Celular celular = celulares.get(numDestino);
			if (celular.obterEstado() == EM_LIGACAO) {
				numLigacoes++;
				notify();
				return celular.terminarLigacao();
			}
			return TERMINADA;
		}
		EstacaoBase estacaoDestino = buscarEstacao(numDestino);
		if(estacaoDestino == null)
			return NUMERO_INVALIDO;
		
		return estacaoDestino.terminarLigacao(numDestino);
	}
	
	public int obterId(){
		return id;
	}
}

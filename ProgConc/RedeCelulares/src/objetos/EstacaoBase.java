package objetos;

import static estados.EstadoCelular.*;
import static estados.EstadoLigacao.*;
import static mensagem.CodigosMensagem.*;
import java.util.HashMap;
import java.util.Map;

import estados.EstadoLigacao;

import log.Log;
import mensagem.CaixaPostal;
import mensagem.Mensagem;

public class EstacaoBase extends Thread {
	private Map<NumCelular, Celular> listaCelulares = new HashMap<NumCelular, Celular>();
	private Map<NumCelular, Celular> chamadasPendentes = new HashMap<NumCelular, Celular>();
	private Map<NumCelular, EstacaoBase> chamadasEmAndamento = new HashMap<NumCelular, EstacaoBase>();
	private CaixaPostal caixaPostal;
	private int numLigacoes = 10;
	private int id;

	//TODO Sempre que uma chamada não é completada ela deve ser terminada em ambas as partes
	
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
				requisitarLigacao(msg.obterCelular(), msg.obterNumeroDestino());
				break;
			case CELULAR_LOCALIZADO:
				completarLigacao(msg.obterNumeroDestino(), msg.obterEstacao());
				break;
			case RECEBER_LIGACAO:
				receberLigacao(msg.obterNumeroOrigem(), msg.obterEstacao(), msg.obterNumeroDestino());
				break;
			case TERMINAR_LIGACAO:
				terminarLigacao(msg.obterNumeroDestino());
				break;
			case RESPOSTA_CELULAR:
				verificarRespostaCelular(msg.obterEstadoLigacao(), msg.obterNumeroDestino());
				break;
			case RESPOSTA_ESTACAO:
				informarCelular(msg.obterNumeroDestino(), msg.obterEstadoLigacao());
			}
		}
	}

	private void associarCelular(Celular celular) {
		Mensagem msg = new Mensagem();
		NumCelular numCelular = celular.obterNumero();

		msg.definirCodigo(ADICIONAR_CELULAR);
		msg.definirNumeroDestino(numCelular);
		msg.definirEstacao(this);

		listaCelulares.put(numCelular, celular);
		ServidorCentral.send(msg);
	}

	private void desassociarCelular(Celular celular) {
		Mensagem msg = new Mensagem();
		NumCelular numCelular = celular.obterNumero();

		msg.definirCodigo(REMOVER_CELULAR);
		msg.definirNumeroDestino(numCelular);

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
		
		chamadasPendentes.put(numDestino, origem);
		
		if(listaCelulares.containsKey(numDestino))
			completarLigacao(numDestino, this);
		else
			buscarEstacao(numDestino);
	}

	private void completarLigacao(NumCelular numDestino, EstacaoBase estacaoDestino) {
		Mensagem msg = new Mensagem();
		Celular origem = chamadasPendentes.remove(numDestino);

		if (estacaoDestino == null) {
			//FIXME Substituir esse trecho por TERMINAR_LIGACAO
			msg.definirCodigo(RESPOSTA_CELULAR);
			msg.definirEstadoLigacao(NUMERO_INVALIDO);
			origem.send(msg);

			notify();
			numLigacoes++;
			return;
		}

		msg.definirCodigo(RECEBER_LIGACAO);
		msg.definirEstacao(this);
		msg.definirNumeroOrigem(origem.obterNumero());
		msg.definirNumeroDestino(numDestino);		
		estacaoDestino.send(msg);
	}

	private void buscarEstacao(NumCelular numDestino) {
		Mensagem msg = new Mensagem();
		msg.definirCodigo(BUSCAR_ESTACAO);
		msg.definirNumeroDestino(numDestino);
		msg.definirEstacao(this);
		ServidorCentral.send(msg);
	}

	private void receberLigacao(NumCelular numOrigem, EstacaoBase estacaoOrigem, NumCelular numDestino) {
		assert (listaCelulares.containsKey(numDestino));
		try {
			while (numLigacoes == 0)
				wait();
		} catch (InterruptedException e) {
			Log.adicionarLog(e.toString());
		}
		numLigacoes--;
		chamadasEmAndamento.put(numOrigem, estacaoOrigem);
		Celular celular = listaCelulares.get(numDestino);

		Mensagem msg = new Mensagem();
		msg.definirCodigo(RECEBER_LIGACAO);
		msg.definirNumeroOrigem(numOrigem);
		celular.send(msg);
	}

	private void verificarRespostaCelular(EstadoLigacao estadoLigacao,
			NumCelular numeroDestino) {
		Mensagem msg = new Mensagem();
		EstacaoBase estacaoDestino = chamadasEmAndamento.get(numeroDestino);
		msg.definirCodigo(RESPOSTA_ESTACAO);
		msg.definirNumeroDestino(numeroDestino);
		msg.definirEstadoLigacao(estadoLigacao);
		
		estacaoDestino.send(msg);		
	}
	
	private void informarCelular(NumCelular numCelular, EstadoLigacao estadoLigacao) {
		Mensagem msg = new Mensagem();
		msg.definirCodigo(RESPOSTA_CELULAR);
		msg.definirEstadoLigacao(estadoLigacao);
		Celular celular = listaCelulares.get(numCelular);
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
		msg.definirNumeroDestino(numDestino);

		// TODO estacaoDestino.send(msg);
	}

	public int obterId() {
		return id;
	}

	public void send(Mensagem msg) {
		caixaPostal.send(msg);
	}
}

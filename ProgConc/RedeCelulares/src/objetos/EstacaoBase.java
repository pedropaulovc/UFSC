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

@SuppressWarnings("unused") //TODO remover após testes
public class EstacaoBase extends Thread {
	private Map<NumCelular, Celular> celularesLocais = new HashMap<NumCelular, Celular>();
	private Map<NumCelular, Celular> chamadasPendentes = new HashMap<NumCelular, Celular>();
	private Map<NumCelular, EstacaoBase> chamadasEmAndamento = new HashMap<NumCelular, EstacaoBase>();
	private ServidorCentral servidorCentral = ServidorCentral.obterInstancia();
	private CaixaPostal caixaPostal;
	// private int numLigacoes = 10; //FIXME Agora que não se usa mais
	// synchronized deve-se remodelar essa parte.
	private int id;

	//FIXME Provavelmente o programa está dando dead lock porque nessa versão a torre manda mensagens
	//para ela mesma. Se a caixa estiver cheia ela não sairá do send, logo nunca voltará ao receive.
	//TODO Reimplementar os métodos que usam send() para verificar se a mensagem foi enviada corretamente.
	//Caso não seja, uma ação de correção para retornar ao estado inicial. 
	
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
				receberLigacao(msg.obterNumeroOrigem(), msg.obterEstacao(),
						msg.obterNumeroDestino());
				break;
			case RECEBER_TERMINO_LIGACAO:
				terminarLigacao(msg.obterNumeroDestino(),
						msg.obterEstadoLigacao());
				break;
			case RESPOSTA_CELULAR:
				verificarRespostaCelular(msg.obterEstadoLigacao(),
						msg.obterNumeroDestino());
				break;
			case RESPOSTA_ESTACAO:
				informarCelular(msg.obterNumeroDestino(),
						msg.obterEstadoLigacao());
				break;
			case TIME_OUT:
				Log.adicionarLog("Estação "+ id + ": TIME_OUT", 2);
				break;
			}
		}
	}

	private void associarCelular(Celular celular) {
		Log.adicionarLog("Estação " + id + " associando celular "
				+ celular.obterNumero(), 1);

		Mensagem msg = new Mensagem();
		NumCelular numCelular = celular.obterNumero();

		msg.definirCodigo(ADICIONAR_CELULAR);
		msg.definirNumeroDestino(numCelular);
		msg.definirEstacao(this);

		celularesLocais.put(numCelular, celular);
		servidorCentral.send(msg);
	}

	private void desassociarCelular(Celular celular) {
		Log.adicionarLog("Estação " + id + " desassociando celular "
				+ celular.obterNumero(), 0);

		Mensagem msg = new Mensagem();
		NumCelular numCelular = celular.obterNumero();

		msg.definirCodigo(REMOVER_CELULAR);
		msg.definirNumeroDestino(numCelular);

		celularesLocais.remove(numCelular);
		servidorCentral.send(msg);
	}

	private void requisitarLigacao(Celular origem, NumCelular numDestino) {
		// try {
		// while (numLigacoes == 0)
		// wait();
		// } catch (InterruptedException e) {
		// Log.adicionarLog(e.toString());
		// }
		// numLigacoes--;
		Log.adicionarLog("Estação " + id + ": " + origem.obterNumero()
				+ " requisitando ligação com " + numDestino, 0);

		if (origem.obterNumero().equals(numDestino)) {
			terminarLigacao(origem.obterNumero(), NUMERO_INVALIDO);
			return;
		}

		chamadasPendentes.put(numDestino, origem);

		if (celularesLocais.containsKey(numDestino))
			completarLigacao(numDestino, this);
		else
			buscarEstacao(numDestino);
	}

	private void completarLigacao(NumCelular numDestino,
			EstacaoBase estacaoDestino) {
		Mensagem msg = new Mensagem();
		Celular origem = chamadasPendentes.remove(numDestino);
		Log.adicionarLog("Estação " + id + ": completando ligação entre "
				+ origem.obterNumero() + " e " + numDestino, 0);

		if (estacaoDestino == null) {
			terminarLigacao(origem.obterNumero(), NUMERO_INVALIDO);
			return;
		}
		
		if (estacaoDestino == this){
			receberLigacao(origem.obterNumero(), this, numDestino);
			return;
		}

		msg.definirCodigo(RECEBER_LIGACAO);
		msg.definirEstacao(this);
		msg.definirNumeroOrigem(origem.obterNumero());
		msg.definirNumeroDestino(numDestino);
		estacaoDestino.send(msg);
	}

	private void buscarEstacao(NumCelular numDestino) {
		Log.adicionarLog("Estação " + id + ": Buscando " + numDestino, 0);
		Mensagem msg = new Mensagem();
		msg.definirCodigo(BUSCAR_ESTACAO);
		msg.definirNumeroDestino(numDestino);
		msg.definirEstacao(this);
		servidorCentral.send(msg);
	}

	private void receberLigacao(NumCelular numOrigem,
			EstacaoBase estacaoOrigem, NumCelular numDestino) {
		assert (celularesLocais.containsKey(numDestino));
		Log.adicionarLog("Estação " + id + ": Recebendo ligação de "
				+ numOrigem + " para " + numDestino, 0);
		// try {
		// while (numLigacoes == 0)
		// wait();
		// } catch (InterruptedException e) {
		// Log.adicionarLog(e.toString());
		// }
		// numLigacoes--;
		chamadasEmAndamento.put(numOrigem, estacaoOrigem);
		Celular celular = celularesLocais.get(numDestino);

		Mensagem msg = new Mensagem();
		msg.definirCodigo(RECEBER_LIGACAO);
		msg.definirNumeroOrigem(numOrigem);
		celular.send(msg);
	}

	private void verificarRespostaCelular(EstadoLigacao estadoLigacao,
			NumCelular numeroDestino) {
		Log.adicionarLog("Estação " + id + ": Estado da ligação de "
				+ numeroDestino + ": " + estadoLigacao, 0);
		Mensagem msg = new Mensagem();
		msg.definirEstadoLigacao(estadoLigacao);
		msg.definirNumeroDestino(numeroDestino);
		EstacaoBase estacaoDestino = chamadasEmAndamento.get(numeroDestino);

		if (estadoLigacao == INICIADA) {
			msg.definirCodigo(RESPOSTA_ESTACAO);
		} else {
			msg.definirCodigo(RECEBER_TERMINO_LIGACAO);
			chamadasEmAndamento.remove(numeroDestino);
		}
		
		if (estacaoDestino == this){
			if (estadoLigacao == INICIADA) {
				informarCelular(numeroDestino, estadoLigacao);
			}else{
				terminarLigacao(numeroDestino, estadoLigacao);
			}
			return;
		}
		estacaoDestino.send(msg);
	}

	private void informarCelular(NumCelular numCelular,
			EstadoLigacao estadoLigacao) {
		Log.adicionarLog("Estação " + id + ": Informando celular " + numCelular
				+ ". Estado: " + estadoLigacao, 0);
		Mensagem msg = new Mensagem();
		msg.definirCodigo(RESPOSTA_CELULAR);
		msg.definirEstadoLigacao(estadoLigacao);
		Celular celular = celularesLocais.get(numCelular);
		celular.send(msg);
	}

	private void terminarLigacao(NumCelular numDestino,
			EstadoLigacao estadoLigacao) {
		// terminarLigacao serve tanto para terminar uma ligação em andamento
		// quanto para abortar uma inválida.
		Log.adicionarLog("Estação " + id + ": Terminando ligação de " + numDestino + ". Estado: " + estadoLigacao, 0);
		Mensagem msg = new Mensagem();
		msg.definirCodigo(RECEBER_TERMINO_LIGACAO);
		msg.definirEstadoLigacao(estadoLigacao);

		if (celularesLocais.containsKey(numDestino)) {
			Celular celular = celularesLocais.get(numDestino);
			celular.send(msg);
		} else { //Garantido que os celulares são de estações diferentes 
			EstacaoBase destino = chamadasEmAndamento.remove(numDestino);
			destino.send(msg);
		}

		// numLigacoes++;
		// notify();
	}

	public int obterId() {
		return id;
	}

	public void send(Mensagem msg) {
		caixaPostal.send(msg);
	}
}

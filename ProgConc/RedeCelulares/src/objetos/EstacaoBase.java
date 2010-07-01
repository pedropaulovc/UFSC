package objetos;

import static estados.EstadoCelular.*;
import static estados.EstadoLigacao.*;
import static mensagem.CodigosMensagem.*;
import static mensagem.CodigosErro.*;
import java.util.HashMap;
import java.util.Map;

import estados.EstadoLigacao;

import log.Log;
import mensagem.CaixaPostal;
import mensagem.Mensagem;

@SuppressWarnings("unused")
// TODO remover após testes
public class EstacaoBase extends Thread {
	private Map<NumCelular, Celular> celularesLocais = new HashMap<NumCelular, Celular>();
	private Map<NumCelular, Celular> chamadasPendentes = new HashMap<NumCelular, Celular>();
	private Map<NumCelular, EstacaoBase> chamadasEmAndamento = new HashMap<NumCelular, EstacaoBase>();
	private ServidorCentral servidorCentral = ServidorCentral.obterInstancia();
	private CaixaPostal caixaPostal;
	// private int numLigacoes = 10; //FIXME Agora que não se usa mais
	// synchronized deve-se remodelar essa parte.
	private int id;

	// TODO Reimplementar os métodos que usam send() para verificar se a
	// mensagem foi enviada corretamente.
	// Caso não seja, uma ação de correção para retornar ao estado inicial.
	// FIXME Verificar mensagens com falta de informação (NullPointer nas
	// estações)

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
				receberLigacao(msg.obterNumeroOrigem(), msg.obterEstacao(), msg
						.obterNumeroDestino());
				break;
			case RECEBER_TERMINO_LIGACAO:
				terminarLigacao(msg.obterNumeroDestino(), msg
						.obterEstadoLigacao());
				break;
			case RESPOSTA_CELULAR:
				verificarRespostaCelular(msg.obterEstadoLigacao(), msg
						.obterNumeroDestino());
				break;
			case RESPOSTA_ESTACAO:
				informarCelular(msg.obterNumeroDestino(), msg
						.obterEstadoLigacao());
				break;
			case TIME_OUT:
				Log.adicionarLog("Estação " + id + ": TIME_OUT", 2);
				break;
			case ERRO:
				tratarErro(msg);
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

		boolean enviado = servidorCentral.send(msg);

		if (!enviado) {
			msg = new Mensagem();
			msg.definirCodigo(ERRO);
			msg.definirCodigoErro(NAO_ASSOCIADO);

			celular.send(msg);
			return;
		}
		celularesLocais.put(numCelular, celular);
	}

	private void desassociarCelular(Celular celular) {
		Log.adicionarLog("Estação " + id + " desassociando celular "
				+ celular.obterNumero(), 1);

		Mensagem msg = new Mensagem();
		NumCelular numCelular = celular.obterNumero();

		msg.definirCodigo(REMOVER_CELULAR);
		msg.definirNumeroDestino(numCelular);

		boolean enviado = servidorCentral.send(msg);

		// TODO Verificar coerência do tratamento de erro
		if (!enviado) {
			msg = new Mensagem();
			msg.definirCodigo(ERRO);
			msg.definirCodigoErro(NAO_DESASSOCIADO);

			celular.send(msg);
			return;
		}
		celularesLocais.remove(numCelular);
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
				+ " requisitando ligação com " + numDestino, 1);

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
		assert (chamadasPendentes.get(numDestino) != null);

		Mensagem msg = new Mensagem();
		Celular origem = chamadasPendentes.get(numDestino);
		Log.adicionarLog("Estação " + id + ": completando ligação entre "
				+ origem.obterNumero() + " e " + numDestino, 1);

		if (estacaoDestino == null) {
			terminarLigacao(origem.obterNumero(), NUMERO_INVALIDO);
			return;
		}

		if (estacaoDestino == this) {
			receberLigacao(origem.obterNumero(), this, numDestino);
			return;
		}

		msg.definirCodigo(RECEBER_LIGACAO);
		msg.definirEstacao(this);
		msg.definirNumeroOrigem(origem.obterNumero());
		msg.definirNumeroDestino(numDestino);
		boolean enviado = estacaoDestino.send(msg);

		if (!enviado) {
			terminarLigacao(origem.obterNumero(), DESTINO_NAO_DISPONIVEL);
			chamadasPendentes.remove(numDestino);
			return;
		}
		
	}

	private void buscarEstacao(NumCelular numDestino) {
		Log.adicionarLog("Estação " + id + ": Buscando " + numDestino, 1);
		Mensagem msg = new Mensagem();
		msg.definirCodigo(BUSCAR_ESTACAO);
		msg.definirNumeroDestino(numDestino);
		msg.definirEstacao(this);
		boolean enviado = servidorCentral.send(msg);

		if (!enviado) {
			Celular origem = chamadasPendentes.remove(numDestino);
			terminarLigacao(origem.obterNumero(), DESTINO_NAO_DISPONIVEL);
			return;
		}
	}

	private void receberLigacao(NumCelular numOrigem,
			EstacaoBase estacaoOrigem, NumCelular numDestino) {
		assert (celularesLocais.containsKey(numDestino));
		Log.adicionarLog("Estação " + id + ": Recebendo ligação de "
				+ numOrigem + " para " + numDestino, 1);
		// try {
		// while (numLigacoes == 0)
		// wait();
		// } catch (InterruptedException e) {
		// Log.adicionarLog(e.toString());
		// }
		// numLigacoes--;

		Celular celular = celularesLocais.get(numDestino);

		Mensagem msg = new Mensagem();
		msg.definirCodigo(RECEBER_LIGACAO);
		msg.definirNumeroOrigem(numOrigem);
		boolean enviado = celular.send(msg);

		if (!enviado) {
			msg = new Mensagem();
			msg.definirCodigo(ERRO);
			msg.definirCodigoErro(DESTINO_INDISPONIVEL);
			msg.definirNumeroDestino(numOrigem);

			if (estacaoOrigem == this) {
				terminarLigacao(numOrigem, CELULAR_OCUPADO);
				return;
			}

			estacaoOrigem.send(msg);
			return;
		}
		chamadasEmAndamento.put(numOrigem, estacaoOrigem);
	}

	private void verificarRespostaCelular(EstadoLigacao estadoLigacao,
			NumCelular numeroDestino) {
		Log.adicionarLog("Estação " + id + ": Estado da ligação de "
				+ numeroDestino + ": " + estadoLigacao, 1);
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

		if (estacaoDestino == this) {
			if (estadoLigacao == INICIADA) {
				informarCelular(numeroDestino, estadoLigacao);
			} else {
				terminarLigacao(numeroDestino, estadoLigacao);
			}
			return;
		}

		// Isso pode ser reduzido para while(!estacaoDestino.send());
		// TODO verificar lógica
		boolean enviado = false;
		while (!enviado) {
			enviado = estacaoDestino.send(msg);
		}
	}

	private void informarCelular(NumCelular numCelular,
			EstadoLigacao estadoLigacao) {
		Log.adicionarLog("Estação " + id + ": Informando celular " + numCelular
				+ ". Estado: " + estadoLigacao, 1);
		Mensagem msg = new Mensagem();
		msg.definirCodigo(RESPOSTA_CELULAR);
		msg.definirEstadoLigacao(estadoLigacao);
		Celular celular = celularesLocais.get(numCelular);

		// Neste momento o celular está em modo TENTANDO_LIGACAO. Pela
		// modelagem, ele ficará aguardando
		// uma resposta da estação base antes de prosseguir com sua execução.
		// Assim, não é necessário
		// tratar um erro de envio.
		celular.send(msg);
	}

	private void terminarLigacao(NumCelular numDestino,
			EstadoLigacao estadoLigacao) {
		// terminarLigacao serve tanto para terminar uma ligação em andamento
		// quanto para abortar uma inválida.
		Log.adicionarLog("Estação " + id + ": Terminando ligação de "
				+ numDestino + ". Estado: " + estadoLigacao, 1);
		Mensagem msg = new Mensagem();
		msg.definirCodigo(RECEBER_TERMINO_LIGACAO);
		msg.definirEstadoLigacao(estadoLigacao);

		// Neste momento o celular está em modo TENTANDO_LIGACAO ou EM_LIGACAO.
		// Pela modelagem, ele está apto a receber mensagens da estação.
		if (celularesLocais.containsKey(numDestino)) {
			Celular celular = celularesLocais.get(numDestino);
			if (!celular.send(msg))
				Log.adicionarLog("Estação " + id
						+ ": Envio de término de ligação para celular "
						+ numDestino + " falhou.", 1);
		} else { // Garantido que os celulares são de estações diferentes
			EstacaoBase destino = chamadasEmAndamento.remove(numDestino);
			if (!destino.send(msg))
				Log.adicionarLog("Estação " + id
						+ ": Envio de término de ligação para estação "
						+ destino.obterId() + " falhou.", 1);
		}

		// numLigacoes++;
		// notify();
	}

	private void tratarErro(Mensagem msg) {
		switch (msg.obterCodigoErro()) {
		case DESTINO_INDISPONIVEL:
			terminarLigacao(msg.obterNumeroDestino(), DESTINO_NAO_DISPONIVEL);
			break;
		}
	}

	public int obterId() {
		return id;
	}

	public boolean send(Mensagem msg) {
		return caixaPostal.send(msg);
	}
}

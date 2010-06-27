package objetos;

import java.util.Random;

import log.Log;
import mensagem.CaixaPostal;
import mensagem.Mensagem;

import estados.EstadoCelular;
import estados.EstadoLigacao;
import static estados.EstadoCelular.*;
import static estados.EstadoLigacao.*;
import static mensagem.CodigosMensagem.*;

public class Celular extends Thread {
	private final NumCelular num;
	private EstadoCelular status;
	private EstacaoBase estacao;
	private CaixaPostal caixaPostal;
	private NumCelular emLigacao;

	public Celular(NumCelular num, EstacaoBase estacao) {
		this.num = num;
		this.status = LIVRE;
		this.estacao = estacao;
		this.caixaPostal = new CaixaPostal();

		Mensagem msg = new Mensagem();
		msg.definirCodigo(ASSOCIAR_CELULAR);
		msg.definirCelular(this);
		estacao.send(msg);
	}

	public void run() {
		float estado;
		Mensagem msg;

		while (true) {
			msg = new Mensagem();
			estado = new Random().nextFloat();
			if (estado < 0.8) { // Celular está em modo ativo
				if (status == LIVRE)
					msg.definirCodigo(REQUISITAR_LIGACAO);
				if (status == EM_LIGACAO)
					msg.definirCodigo(ENVIAR_TERMINO_LIGACAO);
			}
			if (msg.obterCodigo() == null) // Celular está em modo passivo
				msg = caixaPostal.receive();

			switch (msg.obterCodigo()) {
			case REQUISITAR_LIGACAO:
				fazerLigacao(NumCelular.gerarNumeroAleatorio());
				break;
			case RECEBER_LIGACAO:
				receberLigacao(msg.obterNumeroOrigem());
				break;
			case RECEBER_TERMINO_LIGACAO:
				receberTerminoLigacao();
				break;
			case ENVIAR_TERMINO_LIGACAO:
				enviarTerminoLigacao();
				break;
			case RESPOSTA_CELULAR:
				verificarResultadoLigacao(msg.obterEstadoLigacao());
				break;
			}
		}
	}

	public NumCelular obterNumero() {
		return num;
	}

	private void fazerLigacao(NumCelular aLigar) {
		Log.adicionarLog("Celular " + num + ": Ligando para " + aLigar, 0);
		assert (status == LIVRE);
		Mensagem msg = new Mensagem();
		status = TENTANDO_LIGACAO;

		msg.definirCodigo(REQUISITAR_LIGACAO);
		msg.definirNumeroDestino(aLigar);
		msg.definirCelular(this);
		estacao.send(msg);

		// FIXME Necessário?
		// try {
		// sleep(5 * 1000);
		// } catch (InterruptedException e) {
		// Log.adicionarLog(e.getMessage());
		// }
	}

	private void receberLigacao(NumCelular origem) {
		Log.adicionarLog("Celular " + num + ": Recebendo ligação de " + origem
				+ ". Status antes: " + status, 0);
		Mensagem msg = new Mensagem();
		msg.definirCodigo(RESPOSTA_CELULAR);
		msg.definirNumeroDestino(origem);

		if (status == LIVRE) {
			status = EM_LIGACAO;
			emLigacao = origem;
			msg.definirEstadoLigacao(INICIADA);
		} else if (status == DESLIGADO) {
			msg.definirEstadoLigacao(CELULAR_DESLIGADO);
		} else {
			msg.definirEstadoLigacao(CELULAR_OCUPADO);
		}

		estacao.send(msg);
	}

	private void receberTerminoLigacao() {
		assert (status == EM_LIGACAO || status == TENTANDO_LIGACAO);
		Log.adicionarLog("Celular " + num + ": Recebeu término de ligação.", 0);

		emLigacao = null;
		status = LIVRE;
	}

	private void enviarTerminoLigacao() {
		assert (emLigacao != null);
		Log.adicionarLog("Celular " + num + ": Enviando término de ligação.", 0);
		Mensagem msg = new Mensagem();
		msg.definirCodigo(ENVIAR_TERMINO_LIGACAO);
		msg.definirNumeroDestino(emLigacao);

		emLigacao = null;
		status = LIVRE;

		estacao.send(msg);
	}

	private void verificarResultadoLigacao(EstadoLigacao estadoLigacao) {
		Log.adicionarLog("Celular " + num + ": Estado da ligação: "
				+ estadoLigacao, 0);
		if (estadoLigacao == INICIADA) {
			status = EM_LIGACAO;
		} else {
			status = LIVRE; // FIXME Caso else pode ser desnecessário
		}
	}

	public EstadoCelular obterEstado() {
		return status;
	}

	public void send(Mensagem msg) {
		caixaPostal.send(msg);
	}

}

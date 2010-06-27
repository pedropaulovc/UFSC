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
			estado = new Random().nextFloat();
			if (estado < 0.8 && status != TENTANDO_LIGACAO) {
				msg = new Mensagem();
				msg.definirCodigo(REQUISITAR_LIGACAO);
			} else {
				msg = caixaPostal.receive();
			}
			switch (msg.obterCodigo()) {
			case REQUISITAR_LIGACAO:
				fazerLigacao(NumCelular.gerarNumeroAleatorio());
			case RECEBER_LIGACAO:
				receberLigacao(msg.obterNumeroOrigem());
				break;
			case TERMINAR_LIGACAO:
				terminarLigacao();
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
		assert (status == LIVRE);
		Mensagem msg = new Mensagem();
		status = TENTANDO_LIGACAO;

		Log.adicionarLog(num.toString() + ": Fazendo ligação para "
				+ aLigar.toString());

		msg.definirCodigo(REQUISITAR_LIGACAO);
		msg.definirNumeroDestino(aLigar);
		msg.definirCelular(this);
		estacao.send(msg);

		try {
			sleep(5 * 1000);
		} catch (InterruptedException e) {
			Log.adicionarLog(e.getMessage());
		}
	}

	private void receberLigacao(NumCelular origem) {
		Mensagem msg = new Mensagem();
		msg.definirCodigo(RESPOSTA_CELULAR);
		msg.definirNumeroDestino(origem);

		Log.adicionarLog(num.toString() + ": Recebendo ligação de " + origem + ". Status antes: "
				+ status.toString());
		if (status == LIVRE) {
			status = EM_LIGACAO;
			msg.definirEstadoLigacao(INICIADA);
		}
		if (status == EM_LIGACAO)
			msg.definirEstadoLigacao(CELULAR_OCUPADO);
		if (status == DESLIGADO)
			msg.definirEstadoLigacao(CELULAR_DESLIGADO);
		
		estacao.send(msg);
	}

	private void terminarLigacao() {
		assert (status == EM_LIGACAO);
		Mensagem msg = new Mensagem();

		status = LIVRE;
		Log.adicionarLog(num.toString() + ": Terminou ligação.");

		msg.definirCodigo(TERMINAR_LIGACAO);

		estacao.send(msg);
	}

	private void verificarResultadoLigacao(EstadoLigacao estadoLigacao) {
		if (estadoLigacao == INICIADA) {
			status = EM_LIGACAO;
		} else {
			status = LIVRE;
		}

		Log.adicionarLog(num.toString() + ": Status ligação: "
				+ estadoLigacao.toString());
	}

	public EstadoCelular obterEstado() {
		return status;
	}

	public void send(Mensagem msg) {
		caixaPostal.send(msg);
	}

}

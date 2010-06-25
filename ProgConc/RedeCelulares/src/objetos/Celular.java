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
	private NumCelular emLigacao;
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
		while (true) {
			estado = new Random().nextFloat();

			if (estado < 0.2) {
				fazerLigacao(NumCelular.gerarNumeroAleatorio());
				try {
					sleep(5 * 1000);
				} catch (InterruptedException e) {
					Log.adicionarLog(e.getMessage());
				}
				if (status == EM_LIGACAO)
					terminarLigacao();
			}
			if (estado >= 0.2) {
				Mensagem msg = caixaPostal.receive();
				switch (msg.obterCodigo()) {
				case RECEBER_LIGACAO:
					receberLigacao();
					break;
				case TERMINAR_LIGACAO:
					terminarLigacao();
					break;
				case RESULTADO_LIGACAO:
					verificarResultadoLigacao(msg.obterEstadoLigacao(), msg
							.obterNumero());
					break;
				}
			}

		}

	}

	public NumCelular obterNumero() {
		return num;
	}

	private void fazerLigacao(NumCelular aLigar) {
		assert (status == LIVRE);
		Mensagem msg = new Mensagem();

		Log.adicionarLog(num.toString() + ": Fazendo ligação para "
				+ aLigar.toString());

		msg.definirCodigo(FAZER_LIGACAO);
		msg.definirNumero(aLigar);
		estacao.send(msg);
	}

	private void receberLigacao() {
		Mensagem msg = new Mensagem();
		msg.definirCodigo(RESULTADO_LIGACAO);

		Log.adicionarLog(num.toString() + ": Recebendo ligação. Status antes: "
				+ status.toString());
		if (status == EM_LIGACAO)
			msg.definirEstadoLigacao(CELULAR_OCUPADO);
		if (status == DESLIGADO)
			msg.definirEstadoLigacao(CELULAR_DESLIGADO);
		if (status == LIVRE) {
			status = EM_LIGACAO;
			emLigacao = msg.obterNumero();
			msg.definirEstadoLigacao(INICIADA);
		}

		estacao.send(msg);
	}

	private void terminarLigacao() {
		assert (status == EM_LIGACAO);
		Mensagem msg = new Mensagem();

		status = LIVRE;
		Log.adicionarLog(num.toString() + ": Terminou ligação.");

		msg.definirCodigo(TERMINAR_LIGACAO);
		msg.definirNumero(emLigacao);

		emLigacao = null;
		estacao.send(msg);
	}

	private void verificarResultadoLigacao(EstadoLigacao estadoLigacao,
			NumCelular aLigar) {
		if (estadoLigacao == INICIADA) {
			emLigacao = aLigar;
			status = EM_LIGACAO;
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

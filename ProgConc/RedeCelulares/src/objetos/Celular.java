package objetos;

import static mensagem.CodigosMensagem.*;
import static estados.EstadoCelular.*;
import static estados.EstadoLigacao.*;

import java.util.Random;

import estados.EstadoCelular;
import log.Log;
import mensagem.CaixaPostal;
import mensagem.Mensagem;

public class Celular extends Thread {

	CaixaPostal caixaPostal = CaixaPostal.obterCaixa();
	int torreAtual;
	NumCelular numero;
	EstadoCelular estado;

	public Celular(NumCelular num, int torreAtual) {
		this.numero = num;
		this.torreAtual = torreAtual;
		this.estado = LIVRE;
		cadastrarNaTorre(torreAtual);
	}

	public void run() {
		while (true) {
			boolean ativo = new Random().nextBoolean();
			if (ativo && estado == LIVRE) {
				fazerLigacao();
			} else {
				Mensagem msg = new Mensagem();
				msg.definirCodigo(TIMEOUT);
				if (caixaPostal.caixaCheia(numero.obterNumero()))
					msg = caixaPostal.receive(numero.obterNumero());
				switch (msg.obterCodigo()) {
				case RECEBER_LIGACAO:
					receberLigacao(msg);
					break;
				default:
					break;
				}
			}
		}
	}

	private void fazerLigacao() {
		NumCelular numDestino = NumCelular.gerarNumeroAleatorio();
		Log.adicionarLog("Celular " + numero + " na torre " + torreAtual
				+ " fazendo ligação para " + numDestino, 0);

		Mensagem msg = new Mensagem();
		msg.definirCodigo(RECEBER_LIGACAO);
		msg.definirDestino(numDestino);
		msg.definirOrigem(numero);
		msg.gerarId();

		estado = TENTANDO_LIGACAO;

		caixaPostal.send(torreAtual, msg);

		Mensagem msgRecebida = caixaPostal.receive(msg.obterId());

		Log.adicionarLog("Celular " + numero + " recebeu resposta: "
				+ msgRecebida.obterEstadoLigacao(), 0);
		if (msgRecebida.obterEstadoLigacao() == COMPLETADA)
			estado = EM_LIGACAO;
		else
			estado = LIVRE;
		Log.adicionarLog("Novo estado de " + numero + ": " + estado, 1);

	}

	private void receberLigacao(Mensagem msg) {
		Mensagem msgResposta = new Mensagem();
		msgResposta.definirCodigo(RESPOSTA_LIGACAO);
		Log.adicionarLog("Celular " + numero + " " + estado
				+ " recebendo ligação de " + msg.obterOrigem(), 0);
		if (estado == LIVRE) {
			msgResposta.definirEstadoLigacao(COMPLETADA);
			estado = EM_LIGACAO;
		} else {
			msgResposta.definirEstadoLigacao(OCUPADO);
		}
		caixaPostal.send(msg.obterId(), msgResposta);
	}

	private void cadastrarNaTorre(int torreAtual) {
		Mensagem msg = new Mensagem();
		msg.definirCodigo(CADASTRAR);
		msg.definirOrigem(numero);
		msg.definirCelular(this);

		caixaPostal.send(torreAtual, msg);
	}

	public EstadoCelular obterEstado() {
		return estado;
	}
}

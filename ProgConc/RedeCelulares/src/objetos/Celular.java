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
	}

	public void run() {
		while (true) {
			boolean ativo = new Random().nextBoolean();
			if (ativo) {
				fazerLigacao();
			} else {
				Mensagem msg = new Mensagem();
				msg.definirCodigo(TIMEOUT);
				if(caixaPostal.caixaCheia(numero.obterNumero()))
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

		estado = TENTANDO_LIGACAO;

		caixaPostal.send(torreAtual, msg);

		Mensagem msgRecebida = caixaPostal.receive(msg.obterId());
		Log.adicionarLog("Celular " + numero + " resposta: "
				+ msgRecebida.obterEstadoLigacao(), 0);
		if (msgRecebida.obterEstadoLigacao() == COMPLETADA)
			estado = EM_LIGACAO;
		else
			estado = LIVRE;
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
}

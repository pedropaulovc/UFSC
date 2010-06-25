package objetos;

import java.util.Random;

import log.Log;

import estados.EstadoCelular;
import estados.EstadoLigacao;
import static estados.EstadoCelular.*;
import static estados.EstadoLigacao.*;

public class Celular extends Thread {
	private final NumCelular num;
	private EstadoCelular status;
	private EstacaoBase estacao;
	private NumCelular emLigacao;
	
	public Celular(NumCelular num, EstacaoBase estacao) {
		this.num = num;
		this.status = LIVRE;
		this.estacao = estacao;
		estacao.associarCelular(this);
	}

	public void run() {
		int opcao;
		while (true) {
			opcao = new Random().nextInt(2);

			if (opcao == 0)
				try {
					sleep(10 * 1000);
				} catch (InterruptedException e) {
					Log.adicionarLog(e.getMessage());
				}
			if (opcao == 1) {
				fazerLigacao(NumCelular.gerarNumeroAleatorio());
				try {
					sleep(5 * 1000);
				} catch (InterruptedException e) {
					Log.adicionarLog(e.getMessage());
				}
				if (status == EM_LIGACAO)
					terminarLigacao();
			}
		}
	}

	public NumCelular obterNumero() {
		return num;
	}

	private synchronized EstadoLigacao fazerLigacao(NumCelular aLigar) {
		if (status != LIVRE)
			return LIGACAO_INVALIDA;

		Log.adicionarLog(num.toString() + ": Fazendo ligação para "
				+ aLigar.toString());

		EstadoLigacao ligacao = estacao.fazerLigacao(aLigar);
		
		if(status == EM_LIGACAO)
			emLigacao = aLigar;
		
		Log.adicionarLog(num.toString() + ": Status ligação: "
				+ ligacao.toString());

		return ligacao;
	}

	public synchronized EstadoLigacao receberLigacao() {
		Log.adicionarLog(num.toString() + ": Recebendo ligação. Status antes: "
				+ status.toString());
		if (status != LIVRE)
			return CELULAR_OCUPADO;
		status = EM_LIGACAO;
		return INICIADA;
	}

	public synchronized EstadoLigacao terminarLigacao() {
		if (status == EM_LIGACAO) {
			status = LIVRE;
			Log.adicionarLog(num.toString() + ": Terminou ligação.");
			estacao.terminarLigacao(emLigacao);
		}
		return TERMINADA;
	}

	public EstadoCelular obterEstado() {
		return status;
	}

}

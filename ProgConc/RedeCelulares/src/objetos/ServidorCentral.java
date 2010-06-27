package objetos;

import java.util.HashMap;
import java.util.Map;

import log.Log;
import mensagem.CaixaPostal;
import mensagem.Mensagem;
import static mensagem.CodigosMensagem.*;

public class ServidorCentral extends Thread {
	private static Map<NumCelular, EstacaoBase> mapaCelulares = new HashMap<NumCelular, EstacaoBase>();
	private static final CaixaPostal caixaPostal = new CaixaPostal();
	private static final ServidorCentral instancia = new ServidorCentral();

	private ServidorCentral() {
		start();
	}

	public static ServidorCentral obterInstancia() {
		return instancia;
	}

	public void run() {
		while (true) {
			Mensagem msg = caixaPostal.receive();
			switch (msg.obterCodigo()) {
			case ADICIONAR_CELULAR:
				adicionarCelular(msg.obterNumeroDestino(), msg.obterEstacao());
				break;
			case BUSCAR_ESTACAO:
				buscarEstacao(msg.obterNumeroDestino(), msg.obterEstacao());
				break;
			case REMOVER_CELULAR:
				removerCelular(msg.obterNumeroDestino());
				break;
			}
		}
	}

	private void buscarEstacao(NumCelular numero, EstacaoBase estacaoRequerente) {
		Log.adicionarLog("Servidor Central: Buscando número " + numero, 0);
		Mensagem msg = new Mensagem();
		msg.definirCodigo(CELULAR_LOCALIZADO);
		msg.definirEstacao(mapaCelulares.get(numero));
		msg.definirNumeroDestino(numero); // TODO: Necessário?
		estacaoRequerente.send(msg);
	}

	private void adicionarCelular(NumCelular numero, EstacaoBase estacao) {
		Log.adicionarLog("Servidor Central: Adicionando celular " + numero, 1);
		mapaCelulares.put(numero, estacao);
	}

	private void removerCelular(NumCelular numero) {
		Log.adicionarLog("Servidor Central: Removendo celular " + numero, 1);
		mapaCelulares.remove(numero);
	}

	public void send(Mensagem msg) {
		caixaPostal.send(msg);
	}

}

package objetos;

import java.util.HashMap;
import java.util.Map;

import mensagem.CaixaPostal;
import mensagem.Mensagem;
import static mensagem.CodigosMensagem.*;

public class ServidorCentral extends Thread {
	private static Map<NumCelular, EstacaoBase> mapaCelulares = new HashMap<NumCelular, EstacaoBase>();
	private static final CaixaPostal caixaPostal = new CaixaPostal();

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

	private static void buscarEstacao(NumCelular numero, EstacaoBase estacaoRequerente) {
		Mensagem msg = new Mensagem();
		msg.definirCodigo(CELULAR_LOCALIZADO);
		msg.definirEstacao(mapaCelulares.get(numero));
		msg.definirNumeroDestino(numero); //TODO: Necessário?
		estacaoRequerente.send(msg);
	}

	private static void adicionarCelular(NumCelular numero, EstacaoBase estacao) {
		mapaCelulares.put(numero, estacao);
	}

	private static void removerCelular(NumCelular numero) {
		mapaCelulares.remove(numero);
	}

	public static void send(Mensagem msg) {
		caixaPostal.send(msg);
	}

}

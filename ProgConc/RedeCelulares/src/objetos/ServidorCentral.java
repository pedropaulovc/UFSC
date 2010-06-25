package objetos;

import java.util.HashMap;
import java.util.Map;

import mensagem.CaixaPostal;
import mensagem.Mensagem;

public class ServidorCentral extends Thread {
	private static Map<NumCelular, EstacaoBase> mapaCelulares = new HashMap<NumCelular, EstacaoBase>();
	private static final CaixaPostal caixaPostal = new CaixaPostal();

	public void run() {
		while (true) {
			Mensagem msg = caixaPostal.receive();
			switch (msg.obterCodigo()) {
			case ADICIONAR_CELULAR:
				adicionarCelular(msg.obterNumero(), msg.obterEstacao());
				break;
			case BUSCAR_ESTACAO:
				buscarEstacao(msg.obterNumero());
				break;
			case CELULAR_CADASTRADO:
				celularCadastrado(msg.obterNumero());
				break;
			case REMOVER_CELULAR:
				removerCelular(msg.obterNumero());
				break;
			}
		}
	}

	private static EstacaoBase buscarEstacao(NumCelular numero) {
		return mapaCelulares.get(numero);
	}

	private static void adicionarCelular(NumCelular numero, EstacaoBase estacao) {
		mapaCelulares.put(numero, estacao);
	}

	private static void removerCelular(NumCelular numero) {
		mapaCelulares.remove(numero);
	}

	private static boolean celularCadastrado(NumCelular numero) {
		return mapaCelulares.containsKey(numero);
	}

	public static void send(Mensagem msg) {
		caixaPostal.send(msg);
	}

}

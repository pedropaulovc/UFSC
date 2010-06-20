package objetos;

import java.util.HashMap;
import java.util.Map;

public class ServidorCentral extends Thread {
	private static Map<NumCelular, EstacaoBase> mapaCelulares = new HashMap<NumCelular, EstacaoBase>();

	public static synchronized EstacaoBase buscarEstacao(NumCelular numero) {
		return mapaCelulares.get(numero);
	}

	public static synchronized void adicionarCelular(NumCelular numero,
			EstacaoBase estacao) {
		mapaCelulares.put(numero, estacao);
	}

	public static synchronized void removerCelular(NumCelular numero) {
		mapaCelulares.remove(numero);
	}
	
	public static synchronized boolean celularCadastrado(NumCelular numero){
		return mapaCelulares.containsKey(numero);
	}

}

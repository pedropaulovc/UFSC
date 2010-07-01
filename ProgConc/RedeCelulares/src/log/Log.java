package log;
public class Log {
	private static int nivelDetalhes = 0;
	private static int numTentativasLigacao = 0;
	private static int numChamadasRecebidas = 0;
	
	private Log() {
	}

	public static void definirNivelDetalhes(int nivelDetalhes) {
		Log.nivelDetalhes = nivelDetalhes;
	}

	public static void adicionarLog(String log, int nivel) {
		if(nivel <= nivelDetalhes)
			System.out.println(log);
	}

	public static void adicionarTentativaLigacao() {
		numTentativasLigacao++;
	}

	public static void adicionarChamadaRecebida() {
		numChamadasRecebidas++;
	}

	public static int obterNumTentativasLigacao() {
		return numTentativasLigacao;
	}

	public static int obterNumChamadasRecebidas() {
		return numChamadasRecebidas;
	}

	public static void exibirEstatísticas() {
		System.out.println("Número de tentativas de ligação: " + numTentativasLigacao);
		System.out.println("Número de chamadas completadas: " + numChamadasRecebidas);
	}
	
	
}

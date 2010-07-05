package log;
public class Log {
	private static int nivelDetalhes = 0;
	
	private Log() {
	}

	public static void definirNivelDetalhes(int nivelDetalhes) {
		Log.nivelDetalhes = nivelDetalhes;
	}

	public static void adicionarLog(String log, int nivel) {
		if(nivel <= nivelDetalhes)
			System.out.println(log);
	}

	public static void exibirEstatísticas() {		
	}
	
	
}

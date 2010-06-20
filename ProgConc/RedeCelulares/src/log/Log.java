package log;
public class Log extends Thread {
	private Log() {
	}

	public static void adicionarLog(String log) {
		System.out.println(log);
	}
}

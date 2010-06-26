package mensagem;

public class CaixaPostal {
	Mensagem mensagem;
	boolean cxcheia;

	public synchronized void send(Mensagem msg) {
		try {
			while (cxcheia)
				wait();
			cxcheia = true;
			mensagem = msg;
			notify();
		} catch (Exception e) {
			System.out.println("   SEND " + e);
		}

	}

	public synchronized Mensagem receive() {
		try {
			while (!cxcheia)
				wait();
			cxcheia = false;
			notify();
		} catch (Exception e) {
			{
				System.out.println("   RECEIVE " + e);
			}
		}
		return mensagem;

	}

}

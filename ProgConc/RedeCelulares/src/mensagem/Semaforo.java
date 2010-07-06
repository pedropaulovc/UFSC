package mensagem;

public class Semaforo {
	private int cont;

	public Semaforo(int cont) {
		this.cont = cont;
	}

	public synchronized void p() {
		try {
			while (cont == 0)
				wait();
			cont--;

		} catch (Exception e) {
		}
	}

	public synchronized boolean p(int timeout) {
		try {
			if (cont == 0)
				wait(timeout);
			if (cont == 0)
				return false;
			cont--;
		} catch (Exception e) {
		}
		return true;
	}

	public synchronized void v() {
		cont++;
		notify();
	}

	public int obterCont() {
		return cont;
	}

}

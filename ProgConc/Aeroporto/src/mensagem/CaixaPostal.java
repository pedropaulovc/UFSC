package mensagem;

public class CaixaPostal {

	Mensagem cxPostal[];
	Semaforo cxCheia[];
	Semaforo cxVazia[];
	int nproc;

	public CaixaPostal(int nproc) {

		this.nproc = nproc;

		cxPostal = new Mensagem[nproc];
		cxCheia = new Semaforo[nproc];
		cxVazia = new Semaforo[nproc];

		for (int i = 0; i < nproc; i++) {
			cxCheia[i] = new Semaforo(0);
			cxVazia[i] = new Semaforo(1);
			cxPostal[i] = new Mensagem();
		}
	}

	public void send(int destino, Mensagem msg) {
		cxVazia[destino].p();
		cxPostal[destino] = msg;
		cxCheia[destino].v();
	}

	public boolean caixaCheia(int destino){
		return cxCheia[destino].obterCont() == 1;
	}
	
	public Mensagem receive(int pid) {
		Mensagem msg;
		cxCheia[pid].p();
		msg = cxPostal[pid];
		cxVazia[pid].v();
		return (msg);
	}

}
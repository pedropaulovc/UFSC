package mensagem;

import java.util.ArrayList;
import java.util.List;

public class CaixaPostal {

	List<Mensagem> cxPostal = new ArrayList<Mensagem>();
	List<Semaforo> cxCheia = new ArrayList<Semaforo>();
	List<Semaforo> cxVazia = new ArrayList<Semaforo>();
	private static final CaixaPostal instancia = new CaixaPostal();

	public void send(int destino, Mensagem msg) {
		cxVazia.get(destino).p();
		cxPostal.set(destino, msg);
		cxCheia.get(destino).v();
	}

	public boolean caixaCheia(int destino) {
		return cxCheia.get(destino).obterCont() == 1;
	}

	public Mensagem receive(int pid) {
		Mensagem msg;
		cxCheia.get(pid).p();
		msg = cxPostal.get(pid);
		cxVazia.get(pid).v();
		return (msg);
	}

	public int gerarNovaCaixaPostal() {
		cxCheia.add(new Semaforo(0));
		cxVazia.add(new Semaforo(1));
		cxPostal.add(null);

		return cxCheia.size() - 1;
	}

	public static CaixaPostal obterCaixa() {
		return instancia;
	}

}
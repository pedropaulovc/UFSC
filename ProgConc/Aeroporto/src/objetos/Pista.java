package objetos;

import java.util.LinkedList;
import java.util.Queue;

public class Pista {
	private Queue<Integer> fila = new LinkedList<Integer>();
	private boolean paraPouso;
	private boolean bloqueada;

	public int obterQtdAvioes() {
		return fila.size();
	}

	public boolean estaModoPouso() {
		return paraPouso;
	}

	public boolean estaVazia() {
		return fila.isEmpty();
	}

	public void tornarModoPouso() {
		paraPouso = true;
	}

	public void adicionarAviao(int pid) {
		fila.add(pid);
	}

	public void tornarModoDecolagem() {
		paraPouso = false;
	}

	public boolean estaBloqueada() {
		return bloqueada;
	}

	public void trocarBloqueio() {
		bloqueada = !bloqueada;
	}

	public boolean estaModoDecolagem() {
		return !paraPouso;
	}

	public int obterPrimeiroDaFila() {
		return fila.peek();
	}

	public int desenfileirarAviao() {
		return fila.remove();
	}
	
	public String toString(){
		String saida = new String();
		for(int i : fila){
			saida = i + " " + saida;
		}
		return saida;
	}
}

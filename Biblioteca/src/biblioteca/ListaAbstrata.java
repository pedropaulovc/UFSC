package biblioteca;

import java.util.ArrayList;
import java.util.List;

public abstract class ListaAbstrata<E> {
	List<E> lista = new ArrayList<E>();
	
	public void adicionar(E e){
		lista.add(e);
	}
	
	public E remover(int e){
		return lista.remove(e);
	}
	
	public int tamanho(){
		return lista.size();
	}
	
	public E obter(int e){
		return lista.get(e);
	}
}

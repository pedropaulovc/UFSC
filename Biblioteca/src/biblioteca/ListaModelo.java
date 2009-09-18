package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class ListaModelo<Tipo> {
	List<Tipo> lista = new ArrayList<Tipo>();
	
	public void adicionar(Tipo e){
		lista.add(e);
	}
	
	public Tipo remover(int e){
		return lista.remove(e);
	}
	
	public int tamanho(){
		return lista.size();
	}
	
	public Tipo obter(int e){
		return lista.get(e);
	}
}

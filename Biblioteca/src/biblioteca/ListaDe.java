package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class ListaDe<Tipo> {
	List<Tipo> lista = new ArrayList<Tipo>();
	
	public boolean adicionar(Tipo e){
		return lista.add(e);
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

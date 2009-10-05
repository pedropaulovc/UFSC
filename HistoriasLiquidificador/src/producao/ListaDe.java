package producao;

import java.util.ArrayList;
import java.util.List;

public class ListaDe<Tipo> {
	private List<Tipo> lista = new ArrayList<Tipo>();
	
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
	
	public List<Tipo> paraList(){
		return lista;
	}
	
	public ListaDe<Tipo> clone(){
		ListaDe<Tipo> listaClone = new ListaDe<Tipo>();
		for(int i = 0; i < lista.size(); i++)
			listaClone.adicionar(lista.get(i));
		return listaClone;
	}
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object outro){
		return lista.equals(((ListaDe<Tipo>) outro).paraList());
	}
}

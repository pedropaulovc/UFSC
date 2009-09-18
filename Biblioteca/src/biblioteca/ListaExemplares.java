package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class ListaExemplares extends ListaAbstrata<Exemplar> {
	private List<Exemplar> lista;
	
	public ListaExemplares(){
		lista = new ArrayList<Exemplar>();
	}
	
	@Override
	public void adicionar(Exemplar e) {
		lista.add(e);
	}

	@Override
	public Exemplar obter(int e) {
		return lista.get(e);
	}

	@Override
	public Exemplar remover(int e) {
		return lista.remove(e);
	}

	@Override
	public int tamanho() {
		return lista.size();
	}

}

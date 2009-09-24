package modelo.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class MapaDe<Tipo1, Tipo2> {
	private Map<Tipo1, Tipo2> mapa = new HashMap<Tipo1, Tipo2>();

	public Tipo2 adicionar(Tipo1 chave, Tipo2 valor){
		return mapa.put(chave, valor);
	}
	
	public void remover(Tipo1 chave){
		mapa.remove(chave);
	}
	
	public int tamanho(){
		return mapa.size();
	}
	
	public Tipo2 obter(Tipo1 chave){
		return mapa.get(chave);
	}
}

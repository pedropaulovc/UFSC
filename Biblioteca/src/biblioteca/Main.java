package biblioteca;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListaModelo<Integer> ls = new ListaModelo<Integer>();
		
		System.out.println(ls.tamanho());
		ls.adicionar(9999);
		System.out.println(ls.tamanho());
		System.out.println(ls.obter(0));
		System.out.println(ls.tamanho());
		System.out.println(ls.remover(0));
		System.out.println(ls.tamanho());
		
	}

}

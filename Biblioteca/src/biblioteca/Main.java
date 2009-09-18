package biblioteca;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListaString ls = new ListaString();
		
		System.out.println(ls.tamanho());
		ls.adicionar("oi");
		System.out.println(ls.tamanho());
		System.out.println(ls.obter(0));
		System.out.println(ls.tamanho());
		System.out.println(ls.remover(0));
		System.out.println(ls.tamanho());
		
	}

}

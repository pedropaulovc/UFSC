import static java.lang.Math.*;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MetodosNewtonianos m = new MetodosNewtonianos();
		m.metodoSecante(new Polinomial(), pow(10, -10), -3, -4);
		
	}

}

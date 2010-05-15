import static java.lang.Math.*;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MetodosNewtonianos m = new MetodosNewtonianos();
		m.newtonGeral(new Polinomial(), pow(10, -10), -2);
	}

}

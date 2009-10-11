package producao.busca;


public class Buscador {
	public static boolean buscaExata(String texto, String buscado) {
		if(texto.equals(buscado))
			return true;
		return false;
	}
}

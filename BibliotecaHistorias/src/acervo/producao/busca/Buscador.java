package acervo.producao.busca;

public class Buscador {
	public static boolean buscaExata(String texto, String buscado) {
		return texto.matches(buscado);
	}
	
	public static boolean buscaExata(int numero, int esperado){
		return (numero == esperado);
	}
	
	public static boolean buscaProfunda(String texto, String buscado) {
		return texto.matches(".*" + buscado + ".*");
	}
	
	public static boolean buscaPorPalavra(String texto, String buscado) {
		return texto.matches(".*\\b" + buscado + "\\b.*");
	}
}

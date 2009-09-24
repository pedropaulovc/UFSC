package controle.biblioteca;

public class AdaptadorDeString {
	public static String adaptarParaMaiusculasSemEspacos(String texto) {
		String saida = texto.replace(' ', '_');
		saida = saida.toUpperCase();
		return saida;
	}
	
	public static String adaptarParaMinusculasComEspacos(String texto){
		String saida = texto.replace('_', ' ');
		saida = saida.toLowerCase();
		return saida;
	}
	
	
	public static int converterParaInt(String num) {
		return Integer.parseInt(num);
	}
	
	public static String adaptarParaPrimeiraLetraMaiusculaComEspacos(String texto){
		String primeiraLetra = texto.substring(0, 1);
		primeiraLetra = primeiraLetra.toUpperCase();
		String restanteTexto = adaptarParaMinusculasComEspacos(texto.substring(1));
		
		return primeiraLetra.concat(restanteTexto);
	}
	
}

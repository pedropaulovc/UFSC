package producao.dados;

public class ValidadorString {
	public static boolean validarStringNaoVazia(String string) {
		if (string == null || string.isEmpty())
			return false;
		return true;
	}
	
}

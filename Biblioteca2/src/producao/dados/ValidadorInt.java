package producao.dados;

import java.util.Calendar;

public class ValidadorInt {

	public static boolean validarAno(int ano) {
		if (ano < 0 || ano > Calendar.getInstance().get(Calendar.YEAR))
			return false;
		return true;
	}

	public static boolean validarNumero(int numero) {
		if (numero < 0)
			return false;
		return true;
	}

}

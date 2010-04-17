package metodos;

public class Outros {

	public static double[][] gerarMatrizHilbertCoeficientes(int ordem) {
		double[][] matriz = new double[ordem][ordem];

		for (int i = 1; i <= ordem; i++)
			for (int j = 1; j <= ordem; j++)
				matriz[i - 1][j - 1] = 1.0f / (i + j - 1);

		return matriz;
	}

	public static double[] gerarMatrizHilbertTermosIndependentes(int ordem) {
		double[] matriz = new double[ordem];

		for (int i = 1; i <= ordem; i++)
			matriz[i - 1] = 1.0f / (i + (ordem + 1) - 1);

		return matriz;
	}

	public static double[][] matriz3x3Coeficientes() {
		double[][] matriz = { { 2, 1, -1 }, { -3, -1, 2 }, { -2, 1, 2 } };

		return matriz;
	}

	public static double[] matriz3x3TermosIndependentes() {
		double[] matriz = { 8, -11, -3 };

		return matriz;
	}

 }

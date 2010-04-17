package metodos;

public class EliminacaoGauss {
	public static double[] solverSistema(double[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			pivotarLinhas(matriz, i);
			dividirLinha(matriz, i);
			subtrairLinhasAbaixo(matriz, i);
		}
		return retrosubstituir(matriz);
	}

	public static double calcularCondicionamento(double[][] matriz) {
		double denominador = 1;

		for (int i = 0; i < matriz.length; i++) {
			double soma = 0;
			for (int j = 0; j < matriz.length; j++)
				soma += matriz[i][j] * matriz[i][j];
			denominador = denominador * Math.sqrt(soma);
		}
		return Math.abs(calcularDeterminante(matriz)) / denominador;
	}

	private static double calcularDeterminante(double[][] matriz) {
		double det = 1;
		for (int i = 0; i < matriz.length; i++) {
			if (pivotarLinhas(matriz, i))
				det *= -1;
			det *= dividirLinha(matriz, i);
			subtrairLinhasAbaixo(matriz, i);
		}
		for (int i = 0; i < matriz.length; i++)
			det *= matriz[i][i];

		return det;
	}

	private static boolean pivotarLinhas(double[][] matriz, int linhaInicial) {
		double maior = 0;
		double modulo;
		int linhaMaior = linhaInicial;

		for (int i = linhaInicial; i < matriz.length; i++) {
			modulo = Math.abs(matriz[i][linhaInicial]);
			if (modulo > maior) {
				maior = modulo;
				linhaMaior = i;
			}
		}

		if (maior == 0) {
			System.out.println("Sistema SPI ou SI");
			System.exit(1);
		}

		double[] temp = matriz[linhaInicial];
		matriz[linhaInicial] = matriz[linhaMaior];
		matriz[linhaMaior] = temp;

		return linhaInicial != linhaMaior;
	}

	private static double[] retrosubstituir(double[][] matriz) {
		double[] resposta = new double[matriz.length];
		double acum = 0;
		for (int i = matriz.length - 1; i >= 0; i--) {
			acum = 0;
			for (int j = i + 1; j < matriz.length; j++)
				acum += matriz[i][j] * resposta[j];
			resposta[i] = (matriz[i][matriz[0].length - 1] - acum)
					/ matriz[i][i];
		}

		return resposta;
	}

	private static double dividirLinha(double[][] matriz, int indice) {
		double fatorDivisao = matriz[indice][indice];
		for (int i = indice; i < matriz[0].length; i++)
			matriz[indice][i] = matriz[indice][i] / fatorDivisao;
		return fatorDivisao;
	}

	private static void subtrairLinhasAbaixo(double[][] matriz, int indice) {
		for (int i = indice + 1; i < matriz.length; i++) {
			double cond = matriz[i][indice];
			for (int j = indice; j < matriz[0].length; j++) {
				matriz[i][j] = matriz[i][j] - cond
						* matriz[indice][j];
			}
		}
	}

}

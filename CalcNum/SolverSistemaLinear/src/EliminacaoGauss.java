public class EliminacaoGauss {
	public static double[] escalonarMatriz(double[][] matriz) {
		for(int i = 0; i < matriz.length; i++){
			pivotarLinhas(matriz, i);
			dividirLinha(matriz, i);
			subtrairLinhasAbaixo(matriz, i);
		}
		return retrosubstituir(matriz);
	}

	// Pivoto as linhas da matriz[linhaInicial][linhaInicial] para baixo
	private static void pivotarLinhas(double[][] matriz, int linhaInicial) {
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
	}

	private static double[] retrosubstituir(double[][] matriz) {
		double[] resposta = new double[matriz.length];
		double acum = 0;
		for(int i = matriz.length - 1; i >= 0; i--){
			acum = 0;
			for(int j = i + 1; j < matriz.length; j++)
				acum += matriz[i][j] * resposta[j];
			resposta[i] = (matriz[i][matriz[0].length - 1] - acum) / matriz[i][i];
		}

		return resposta;
	}

	private static void dividirLinha(double[][] matriz, int indice) {
		double fatorDivisao = matriz[indice][indice];
		for (int i = indice; i < matriz[0].length; i++) {
			matriz[indice][i] = matriz[indice][i] / fatorDivisao;
		}
	}

	private static void subtrairLinhasAbaixo(double[][] matriz, int indice) {
		for (int i = indice + 1; i < matriz.length; i++) {
			double fatorCondenado = matriz[i][indice];
			for (int j = indice; j < matriz[0].length; j++) {
				matriz[i][j] = matriz[i][j] - fatorCondenado
						* matriz[indice][j];
			}
		}
	}

}

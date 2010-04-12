
public class EliminacaoGauss {
	public static void escalonarMatriz(double[][] matriz) {
		
	}

	//Pivoto as linhas da matriz[linhaInicial][linhaInicial] para baixo
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

	private static double[] retrosubstituir(double[][] matriz){
		double[] resposta = new double[matriz.length];
		
		for(int i = matriz.length; i >= 0; i++){
/*			for(int j =  0; i)
			resposta[i] = matriz[i][i + 1]/matriz[i][i];
			resposta[i - 1] = matriz[i][]*/
		}
		return null;
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

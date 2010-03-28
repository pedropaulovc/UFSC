import java.util.Scanner;

public class Escalonador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		float[][] matriz = gerarMatrizHilbert(10);
		System.out.println("INÍCIO: ");
		exibirMatriz(matriz);
		System.out.println("Escalonando: ");
		escalonarMatriz(matriz);
		System.out.println("FIM: ");
		exibirMatriz(matriz);
	}

	private static void escalonarMatriz(float[][] matriz) {
		for (int colPrinc = 0; colPrinc < matriz.length - 1; colPrinc++) {
			pivotarLinhas(matriz, colPrinc);
			System.out.println("Pivotado coluna " + colPrinc);
			exibirMatriz(matriz);
			dividirLinha(matriz, colPrinc);
			System.out.println("Dividida linha " + colPrinc);
			exibirMatriz(matriz);
			subtrairLinhaDeOutra(matriz, colPrinc);
			exibirMatriz(matriz);
			System.out.println("Subtraídas linhas abaixo de " + colPrinc);
		}
	}

	private static void pivotarLinhas(float[][] matriz, int linhaAtual) {
		float maior = 0;
		int linhaMaior = linhaAtual;

		for (int i = linhaAtual; i < matriz.length; i++) {
			if (matriz[i][linhaAtual] > maior) {
				maior = matriz[i][linhaAtual];
				linhaMaior = i;
			}
		}

		if (maior == 0) {
			System.out.println("Sistema SPI ou SI");
			System.exit(1);
		}

		float[] temp = matriz[linhaAtual];
		matriz[linhaAtual] = matriz[linhaMaior];
		matriz[linhaMaior] = temp;
	}

	private static void dividirLinha(float[][] matriz, int indice) {
		float fatorDivisao = matriz[indice][indice];
		for (int i = indice; i < matriz[0].length; i++) {
			matriz[indice][i] = matriz[indice][i] / fatorDivisao;
		}

	}

	private static void subtrairLinhaDeOutra(float[][] matriz, int indice) {
		for (int i = indice + 1; i < matriz.length; i++) {
			float fatorCondenado = matriz[i][indice];
			for (int j = indice; j < matriz[0].length; j++) {
				matriz[i][j] = matriz[i][j] - fatorCondenado
						* matriz[indice][j];
			}
		}
	}

	private static void exibirMatriz(float[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++)
				System.out.printf("%15.12f ", matriz[i][j]);
			System.out.println();
		}
		System.out.println();
	}

	private static float[][] obterMatriz() {
		System.out.print("Forneça tamanho da matriz: ");
		int n = new Scanner(System.in).nextInt();

		float[][] matriz = new float[n][n + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n + 1; j++) {
				System.out.print("Forneça o elemento " + i + "," + j + ": ");
				matriz[i][j] = new Scanner(System.in).nextFloat();
			}
		}

		return matriz;
	}

	private static float[][] gerarMatrizHilbert(int ordem) {
		float[][] matriz = new float[ordem][ordem];

		for (int i = 1; i <= ordem; i++)
			for (int j = 1; j <= ordem; j++)
				matriz[i - 1][j - 1] = 1.0f/(i + j - 1);
				
		return matriz;
	}

}

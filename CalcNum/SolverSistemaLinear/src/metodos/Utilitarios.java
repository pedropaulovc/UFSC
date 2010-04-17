package metodos;

import java.util.Scanner;

public class Utilitarios {

	public static void exibirMatriz(double[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++)
				System.out.printf("%15.12f ", matriz[i][j]);
			System.out.println();
		}
		System.out.println();
	}

	public static void exibirMatriz(double[] matriz) {
		for (int i = 0; i < matriz.length; i++)
			System.out.printf("%15.12f ", matriz[i]);
		System.out.println("\n");
	}

	public static double[][] lerMatriz() {
		System.out.print("Forneça o número de linhas da matriz: ");
		int n = new Scanner(System.in).nextInt();

		double[][] matriz = new double[n][n + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n + 1; j++) {
				System.out.print("Forneça o elemento " + (i + 1) + "," + (j + 1) + ": ");
				matriz[i][j] = new Scanner(System.in).nextDouble();
			}
		}
		return matriz;
	}

	public static double[][] matrizHilbert(int ordem) {
		double[][] matriz = new double[ordem][ordem + 1];

		for (int i = 1; i <= ordem; i++)
			for (int j = 1; j <= ordem + 1; j++)
				matriz[i - 1][j - 1] = 1.0f / (i + j - 1);

		return matriz;
	}

	public static double[][] matrizExemplo1() {
		double[][] matriz = { { 2, 1, -1, 8 }, { -3, -1, 2, -11 },
				{ -2, 1, 2, -3 } };

		return matriz;
	}

	public static double[][] matrizExemplo2() {
		double[][] matriz = { { 2, 1, -1, 8 }, { -3, -1, 2, -11 },
				{ -2, 1, 2, -3 } };

		return matriz;
	}

	public static double[][] matrizIdentidade(int ordem) {
		double[][] matriz = new double[ordem][ordem];
		for (int i = 0; i < ordem; i++)
			matriz[i][i] = 1;
		return matriz;
	}

}

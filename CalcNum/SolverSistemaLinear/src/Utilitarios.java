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

	public static double[][] lerMatriz() {
		System.out.print("Forneça tamanho da matriz: ");
		int n = new Scanner(System.in).nextInt();

		double[][] matriz = new double[n][n + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n + 1; j++) {
				System.out.print("Forneça o elemento " + i + "," + j + ": ");
				matriz[i][j] = new Scanner(System.in).nextDouble();
			}
		}
		return matriz;
	}

	public static double[][] gerarMatrizHilbert(int ordem) {
		double[][] matriz = new double[ordem][ordem + 1];

		for (int i = 1; i <= ordem; i++)
			for (int j = 1; j <= ordem + 1; j++)
				matriz[i - 1][j - 1] = 1.0f / (i + j - 1);

		return matriz;
	}
	
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

	public static void exibirMatriz(double[] matriz) {
		for (int i = 0; i < matriz.length; i++)
			System.out.printf("%15.12f ", matriz[i]);
		System.out.println();
	}

	public static double[][] matriz3x4(){
		double[][] matriz = new double[3][4];
		
		matriz[0][0] = 2;
		matriz[0][1] = 1;
		matriz[0][2] = -1;
		matriz[0][3] = 8;
		matriz[1][0] = -3;
		matriz[1][1] = -1;
		matriz[1][2] = 2;
		matriz[1][3] = -11;
		matriz[2][0] = -2;
		matriz[2][1] = 1;
		matriz[2][2] = 2;
		matriz[2][3] = -3;
		
		return matriz;
	}
	
	public static double[][] matriz3x3Coeficientes(){
		double[][] matriz = new double[3][4];
		
		matriz[0][0] = 2;
		matriz[0][1] = 1;
		matriz[0][2] = -1;
		matriz[1][0] = -3;
		matriz[1][1] = -1;
		matriz[1][2] = 2;
		matriz[2][0] = -2;
		matriz[2][1] = 1;
		matriz[2][2] = 2;
		
		return matriz;
	}
	
	public static double[] matriz3x3TermosIndependentes(){
		double[] matriz = new double[3];
		
		matriz[0] = 8;
		matriz[1] = -11;
		matriz[2] = -3;
		
		return matriz;
	}

}

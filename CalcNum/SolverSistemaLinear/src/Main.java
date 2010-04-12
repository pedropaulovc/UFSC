public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[][] matriz = Utilitarios.gerarMatrizHilbert(3);
		// double[][] matriz = matriz3x4();
		Utilitarios.exibirMatriz(matriz);		
		double[] resposta = EliminacaoGauss.escalonarMatriz(matriz);
		Utilitarios.exibirMatriz(resposta);

		double[] resposta2 = GaussianElimination.lsolve(Utilitarios
				.gerarMatrizHilbertCoeficientes(3), Utilitarios
				.gerarMatrizHilbertTermosIndependentes(3));
		Utilitarios.exibirMatriz(resposta2);
	}
}

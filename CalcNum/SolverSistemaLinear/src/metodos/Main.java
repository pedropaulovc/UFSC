package metodos;

import static metodos.EliminacaoGauss.calcularDeterminante;
import static metodos.Utilitarios.exibirMatriz;
import static metodos.Utilitarios.gerarMatrizHilbert;
import static metodos.Utilitarios.matriz3x4;


public class Main {
	public static void main(String[] args) {
		//double[][] matriz = gerarMatrizHilbert(2);
		double[][] matriz = matriz3x4();

		//double[][] matriz = { { 2, -4, 8 }, { 5, 4, 6 }, { -3, 0, 2 } };
		exibirMatriz(matriz);
		// double[] resposta = calcularResposta(matriz);
		// exibirMatriz(resposta);
		System.out.println(calcularDeterminante(matriz));
	}
}

package metodos;

import static metodos.EliminacaoGauss.calcularCondicionamento;
import static metodos.EliminacaoGauss.solverSistema;
import static metodos.Utilitarios.exibirMatriz;
import static metodos.Utilitarios.matrizHilbert;
import static metodos.Utilitarios.lerMatriz;
import static metodos.Utilitarios.matrizExemplo1;
import static metodos.Utilitarios.matrizExemplo2;
import java.util.Scanner;

public class Main {
	static Scanner scanner;

	public static void main(String[] args) {
		int opcao = 0;
		scanner = new Scanner(System.in);

		exibeIntroducao();
		do {
			exibeMenu();
			opcao = scanner.nextInt();
			
			switch (opcao) {
			case 0:
				System.exit(0);
				break;
			case 1:
				exibirMatriz(solverSistema(selecionarMatriz()));
				break;
			case 2:
				System.out.println(calcularCondicionamento(selecionarMatriz()));
				break;
			default:
				System.out.println("Opção Inválida");
			}
		} while (opcao != 0);
	}

	private static void exibeIntroducao() {
		System.out.println("INE5409 - Cálculo Numérico para Computação");
		System.out.println("Aluno: Pedro Paulo Vezzá Campos - 09132033");
		System.out
				.println("Trabalho 1 - Cálculo do condicionamento de um sistema linear\n");
	}

	private static void exibeMenu() {
		System.out.println("Selecione a opção desejada: ");
		System.out.println("0 - Sair");
		System.out.println("1 - Solver um sistema linear");
		System.out
				.println("2 - Calcular o condicionamento de um sistema linear");
	}

	private static void menuSelecionarMatriz() {
		System.out.println("Selecione a matriz que deseja operar: ");
		System.out.println("1 - Matriz de exemplo 1");
		System.out.println("2 - Matriz de exemplo 2");
		System.out.println("3 - Matriz de Hilbert");
		System.out.println("4 - Inserir a matriz manualmente");
	}

	private static double[][] selecionarMatriz() {
		double[][] matriz = null;
		int ordem, opcao;

		menuSelecionarMatriz();
		opcao = scanner.nextInt();

		switch (opcao) {
		case 1:
			matriz = matrizExemplo1();
			break;
		case 2:
			matriz = matrizExemplo2();
			break;
		case 3:
			do {
				System.out.print("Forneça a ordem da matriz: ");
				ordem = scanner.nextInt();
				if(ordem <= 0)
					System.out.println("A ordem deve ser maior que zero");
			} while (ordem <= 0);

			matriz = matrizHilbert(ordem);
			break;
		case 4:
			matriz = lerMatriz();
			break;
		default:
			System.out.println("Opção inválida");
		}

		System.out.println("Matriz de entrada: ");
		exibirMatriz(matriz);
		System.out.println("Resultado: ");

		return matriz;
	}

}

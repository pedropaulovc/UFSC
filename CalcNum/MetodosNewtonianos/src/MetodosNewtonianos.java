import static java.lang.Math.*;

public class MetodosNewtonianos {
	public void newtonGeral(Funcao funcao, double precisao, double inicial) {
		double den, erroN;
		den = funcao.obterValorDerivada(inicial);
		if (den == 0) {
			System.out.println("Divisão por zero na iteração inicial");
			return;
		}
		double proximo = inicial - funcao.obterValor(inicial) / den;
		int numIteracoes = 0;
		double erroV = abs(proximo - inicial) / max(abs(inicial), abs(proximo));
		inicial = proximo;

		boolean erroDiminuindo = true;
		while (erroDiminuindo) {
			numIteracoes++;
			den = funcao.obterValorDerivada(inicial);
			if (den == 0) {
				System.out.println("Divisão por zero");
				return;
			}

			proximo = inicial - funcao.obterValor(inicial) / den;
			erroN = abs(proximo - inicial) / max(abs(inicial), abs(proximo));

			if (erroN <= precisao) {
				System.out.println("Solução obtida com " + numIteracoes
						+ " iterações: " + proximo);
				return;
			}

			if (erroN >= erroV)
				erroDiminuindo = false;

			inicial = proximo;
			erroV = erroN;
		}
		System.out
				.println("Método pode estar divergindo. Número de iterações: "
						+ numIteracoes);
	}

	public void metodoSecante(Funcao funcao, double precisao, double xk,
			double xkAnt) {
		double den, erroN;
		den = funcao.obterValor(xk) - funcao.obterValor(xkAnt);
		if (den == 0) {
			System.out.println("Divisão por zero na iteração inicial");
			return;
		}
		double proximo = xk - funcao.obterValor(xk) * (xk - xkAnt) / den;
		int numIteracoes = 0;
		double erroV = abs(proximo - xk) / max(abs(xk), abs(proximo));
		xkAnt = xk;
		xk = proximo;

		boolean erroDiminuindo = true;
		while (erroDiminuindo) {
			numIteracoes++;
			den = funcao.obterValor(xk) - funcao.obterValor(xkAnt);
			if (den == 0) {
				System.out.println("Divisão por zero");
				return;
			}

			proximo = xk - funcao.obterValor(xk) * (xk - xkAnt) / den;
			erroN = abs(proximo - xk) / max(abs(xk), abs(proximo));

			if (erroN <= precisao) {
				System.out.println("Solução obtida com " + numIteracoes
						+ " iterações: " + proximo);
				return;
			}

			if (erroN >= erroV)
				erroDiminuindo = false;

			xkAnt = xk;
			xk = proximo;
			erroV = erroN;
		}
		System.out
				.println("Método pode estar divergindo. Número de iterações: "

				+ numIteracoes);
	}
}

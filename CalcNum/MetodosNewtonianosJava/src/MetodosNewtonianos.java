import static java.lang.Math.*;

public class MetodosNewtonianos {
	public void newtonGeral(Funcao funcao, double precisao, double xk) {
		double den, erroN, xkPost;
		den = funcao.obterValorDerivada(xk);
		if (den == 0) {
			System.out.println("Divisão por zero na iteração inicial");
			return;
		}
		xkPost = xk - funcao.obterValor(xk) / den;
		int numIteracoes = 0;
		double erroV = abs(xkPost - xk) / max(abs(xk), abs(xkPost));
		xk = xkPost;

		boolean erroDiminuindo = true;
		while (erroDiminuindo) {
			numIteracoes++;
			den = funcao.obterValorDerivada(xk);
			if (den == 0) {
				System.out.println("Divisão por zero");
				return;
			}

			xkPost = xk - funcao.obterValor(xk) / den;
			erroN = abs(xkPost - xk) / max(abs(xk), abs(xkPost));

			if (erroN <= precisao) {
				System.out.println("Solução obtida com " + numIteracoes
						+ " iterações: " + xkPost);
				return;
			}

			if (erroN >= erroV)
				erroDiminuindo = false;

			xk = xkPost;
			erroV = erroN;
		}
		System.out
				.println("Método pode estar divergindo. Número de iterações: "
						+ numIteracoes);
	}

	public void metodoSecante(Funcao funcao, double precisao, double xk,
			double xkAnt) {
		double den, erroN, xkPost;
		/*den = funcao.obterValor(xk) - funcao.obterValor(xkAnt);
		if (den == 0) {
			System.out.println("Divisão por zero na iteração inicial");
			return;
		}*/
		//double xkPost = xk - funcao.obterValor(xk) * (xk - xkAnt) / den;
		int numIteracoes = 0;
		double erroV = abs(xk - xkAnt) / max(abs(xk), abs(xkAnt));
		/*xkAnt = xk;
		xk = xkPost;*/

		boolean erroDiminuindo = true;
		while (erroDiminuindo) {
			numIteracoes++;
			den = funcao.obterValor(xk) - funcao.obterValor(xkAnt);
			if (den == 0) {
				System.out.println("Divisão por zero");
				return;
			}

			xkPost = xk - funcao.obterValor(xk) * (xk - xkAnt) / den;
			erroN = abs(xkPost - xk) / max(abs(xk), abs(xkPost));

			if (erroN <= precisao) {
				System.out.println("Solução obtida com " + numIteracoes
						+ " iterações: " + xkPost);
				return;
			}

			if (erroN >= erroV)
				erroDiminuindo = false;

			xkAnt = xk;
			xk = xkPost;
			erroV = erroN;
		}
		System.out
				.println("Método pode estar divergindo. Número de iterações: "

				+ numIteracoes);
	}
}

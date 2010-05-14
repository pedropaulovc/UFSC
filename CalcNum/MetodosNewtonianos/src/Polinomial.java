
public class Polinomial implements Funcao {

	@Override
	public double obterValor(double x) {
		return x*x - 128;
	}

	@Override
	public double obterValorDerivada(double x) {
		return Math.pow(2, x)*Math.log(2) - 2*x;
	}

}


public class Polinomial implements Funcao {

	@Override
	public double obterValor(double ponto) {
		return ponto*ponto - 4;
	}

	@Override
	public double obterValorDerivada(double ponto) {
		return 2*ponto;
	}

}

package objetos;

import java.util.Random;

public final class NumCelular {
	private final int numero;
	private static final int maxNum = 2;

	public NumCelular(int numero) {
		assert (numero <= maxNum && numero > 0);
		this.numero = numero;
	}

	public int obterNumero() {
		return numero;
	}

	public static NumCelular gerarNumeroAleatorio() {
		return new NumCelular(new Random().nextInt(maxNum) + 1);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumCelular other = (NumCelular) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

	public String toString() {
		return Integer.toString(numero);
	}

}

package producao.dados.anoPublicacao.modelo;

import static producao.dados.ValidadorInt.validarAno;

import java.util.Calendar;

import producao.dados.ExcecaoParametroInvalido;

public class AnoPublicacao implements TipoAnoPublicacao {

	private int anoPublicacao;

	public AnoPublicacao(int anoPublicacao) throws ExcecaoParametroInvalido {
		assert anoPublicacao > 0;
		assert anoPublicacao <= Calendar.getInstance().get(Calendar.YEAR);

		if (!validarAno(anoPublicacao))
			throw new ExcecaoParametroInvalido(
					"Ano de publicação fora da faixa [0, ano atual]");
		this.anoPublicacao = anoPublicacao;

	}

	public AnoPublicacao(String anoPublicacao) throws ExcecaoParametroInvalido {
		int ano = 0;
		try {
			ano = Integer.parseInt(anoPublicacao);
		} catch (NumberFormatException e) {
			throw new ExcecaoParametroInvalido("Ano de publicação \""
					+ anoPublicacao + "\" inválido");
		}

		if (!validarAno(ano))
			throw new ExcecaoParametroInvalido(
					"Ano de publicação " + ano + " fora da faixa [0, ano atual]");
		this.anoPublicacao = ano;
	}

	public String toString() {
		return Integer.toString(anoPublicacao);
	}
	
	public static boolean validar(int anoPublicacao){
		return validarAno(anoPublicacao);
	}
	
	public static boolean validar(String anoPublicacao){
		int ano;
		try {
			ano = Integer.parseInt(anoPublicacao);
		} catch (NumberFormatException e) {
			return false;
		}
		return validar(ano);
	}

}

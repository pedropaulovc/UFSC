package producao.dados;

public class ExcecaoParametroInvalido extends RuntimeException {

	private static final long serialVersionUID = 5615019260925325837L;

	public ExcecaoParametroInvalido(String mensagem) {
		super(mensagem);
	}
}

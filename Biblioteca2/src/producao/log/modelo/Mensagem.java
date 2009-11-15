package producao.log.modelo;

public class Mensagem implements TipoMensagem {

	private String mensagem;
	private Object object;

	public Mensagem(String mensagem, Object o) {
		this.mensagem = mensagem;
		this.object = o;
	}

	public Object obterObjeto() {
		return object;
	}

	public String toString() {
		return mensagem;
	}
}

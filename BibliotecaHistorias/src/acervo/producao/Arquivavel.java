package acervo.producao;

public abstract class Arquivavel implements TipoArquivavel {
	private Estado estado;

	public void alterarEstado(Estado estado) {
		this.estado = estado;
	}

	public Estado obterEstado() {
		return estado;
	}
	
	
}

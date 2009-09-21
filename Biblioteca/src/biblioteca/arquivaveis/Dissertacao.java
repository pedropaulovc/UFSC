package biblioteca.arquivaveis;

import biblioteca.Documento;

public class Dissertacao extends Arquivavel {
	private String orientador;

	public Dissertacao(Documento documento, String orientador) {
		super(documento);
		this.orientador = orientador;
	}

	public String obterOrientador() {
		return orientador;
	}

	public void alterarOrientador(String orientador) {
		this.orientador = orientador;
	}

	@Override
	public String toString() {
		return super.obterDocumento().obterTitulo() + ". Dissertação de "
				+ super.obterDocumento().obterAutor() + " sob a orientação de "
				+ orientador;
	}

}

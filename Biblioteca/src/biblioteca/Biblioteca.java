package biblioteca;

public class Biblioteca {
	private String nome;
	private ListaDe<Documento> acervo;

	public Biblioteca(String nome) {
		this.nome = nome;
		acervo = new ListaDe<Documento>();
	}

	public String obterNome() {
		return nome;
	}

	public int tamanhoAcervo() {
		return acervo.tamanho();
	}

	public boolean adicionarDocumento(Documento d) {
		return acervo.adicionar(d);
	}

	public Documento obterDocumento(int d) {
		return acervo.obter(d);
	}

	public Documento removerDocumento(int d) {
		return acervo.remover(d);
	}

	public String toString() {
		return nome + ". Possui acervo de " + tamanhoAcervo() + " documentos.";
	}
}